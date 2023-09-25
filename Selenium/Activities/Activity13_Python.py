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
    columns = driver.find_elements(By.XPATH, "//table[contains(@class, 'striped')]/tbody/tr[3]/td")
    rows = driver.find_elements(By.XPATH, "//table[contains(@class, 'striped')]/tbody/tr")
    print("Number of rows: ", len(rows), " and ", "Number of columns: ", len(columns))

    print("Values of third row:")
    for row in columns:
        print("Cell value: ", row.text)

    cell_value = driver.find_element(By.XPATH, "//*[@class=\"ui celled striped table\"]/tbody/tr[2]/td[2]")
    # Print the cell value
    print("Value at second row and second column: ", cell_value.text)

    driver.quit()
    print("End of code")
