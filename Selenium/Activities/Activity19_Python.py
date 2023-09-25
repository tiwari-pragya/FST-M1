from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.select import Select
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager

# setup firefox driver
service1 = FirefoxService(GeckoDriverManager().install())

# start driver
with webdriver.Firefox(service=service1) as driver:
    # open webpage and print title
    driver.get("https://v1.training-support.net/selenium/javascript-alerts")
    print("Title of page is: " + driver.title)
    wait = WebDriverWait(driver, 10)

    # perform activity
    driver.find_element(By.ID, "confirm").click()
    alert = driver.switch_to.alert

    print("Text on Alert: " + alert.text)
    alert.accept()

    driver.find_element(By.ID, "confirm").click()
    alert = driver.switch_to.alert
    alert.dismiss()

    driver.quit()
    print("End of code")
