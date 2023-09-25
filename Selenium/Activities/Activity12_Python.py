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
    driver.get("https://v1.training-support.net/selenium/dynamic-controls")
    print("Title of page is: " + driver.title)
    wait = WebDriverWait(driver, 10)

    # perform activity
    textField = driver.find_element(By.ID, "input-text")
    print("TextField is enabled: ", textField.is_enabled())

    toggle_textfield = driver.find_element(By.ID, "toggleInput")
    toggle_textfield.click()

    print("TextField is enabled: ", textField.is_enabled())
    textField.send_keys("Field is enabled")

    driver.quit()
    print("End of code")
