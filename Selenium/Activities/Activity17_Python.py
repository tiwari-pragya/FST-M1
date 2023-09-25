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
    single_select = driver.find_element(By.ID, "single-select")
    select = Select(single_select)

    select.select_by_visible_text("Option 2")
    print("Value of Select by Visible Text: " + select.first_selected_option.text)
    select.select_by_index(3)
    print("Value of Select by Index: " + select.first_selected_option.text)
    select.select_by_value("4")
    print("Value of Select by Value: " + select.first_selected_option.text)

    print("All options of Single Select: ")
    print(single_select.text)

    driver.quit()
    print("End of code")
