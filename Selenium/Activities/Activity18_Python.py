from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.select import Select
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager

# setup firefox driver
service1 = FirefoxService(GeckoDriverManager().install())

# start driver
with webdriver.Firefox(service=service1) as driver:
    # open webpage and print title
    driver.get("https://v1.training-support.net/selenium/selects")
    print("Title of page is: " + driver.title)
    wait = WebDriverWait(driver, 10)

    # perform activity
    multi_select = driver.find_element(By.ID, "multi-select")
    select = Select(multi_select)

    select.select_by_visible_text("Javascript")
    select.select_by_index(4)
    select.select_by_index(5)
    select.select_by_index(6)
    select.select_by_value("node")
    select.deselect_by_index(5)

    selected = driver.find_element(By.ID, "multi-value").text
    print(selected)

    driver.quit()
    print("End of code")
