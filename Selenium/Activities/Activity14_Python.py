from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager

# setup firefox driver
service1 = FirefoxService(GeckoDriverManager().install())

# start driver
with webdriver.Firefox(service=service1) as driver:
    # open webpage and print title
    driver.get("https://v1.training-support.net/selenium/tables")
    print("Title of page is: " + driver.title)
    wait = WebDriverWait(driver, 10)

    # perform activity
    columns = driver.find_elements(By.XPATH, "//*[@id=\"sortableTable\"]/tbody/tr[1]/td")
    rows = driver.find_elements(By.XPATH, "//*[@id=\"sortableTable\"]/tbody/tr")
    print("Number of rows: ", len(rows), " and ", "Number of columns: ", len(columns))

    cell_value = driver.find_element(By.XPATH, "//*[@id=\"sortableTable\"]/tbody/tr[2]/td[2]")
    print("Value at second row and second column: ", cell_value.text)

    driver.find_element(By.XPATH, "//*[@id=\"sortableTable\"]/thead/tr/th[1]").click()

    cell_value = driver.find_element(By.XPATH, "//*[@id=\"sortableTable\"]/tbody/tr[2]/td[2]")
    print("Value at second row and second column: ", cell_value.text)

    footer = driver.find_elements(By.XPATH, "//*[@id=\"sortableTable\"]/tfoot/tr/th")

    print("Footer Row values:")
    for row in footer:
        print("Cell value: ", row.text)

    driver.quit()
    print("End of code")
