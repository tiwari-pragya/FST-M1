from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager

# setup firefox driver
service1 = FirefoxService(GeckoDriverManager().install())

# start driver
with webdriver.Firefox(service=service1) as driver:
    # open webpage and print title
    driver.get("https://v1.training-support.net/selenium/dynamic-attributes")
    print("Title of page is: " + driver.title)
    wait = WebDriverWait(driver, 10)

    # perform activity
    username = driver.find_element(By.XPATH, "//*[contains(@class, 'username-')]")
    pswd = driver.find_element(By.XPATH, "//*[contains(@class, 'password-')]")
    login = driver.find_element(By.XPATH, "//*[contains(@class, 'password-')]/following::button")

    username.send_keys("admin")
    pswd.send_keys("password")
    login.click()

    # wait for login message and print
    conf_id = driver.find_element(By.ID, "action-confirmation")
    wait.until(expected_conditions.visibility_of(conf_id))
    message = driver.find_element(By.ID, "action-confirmation").text
    print("Login message: " + message)

    driver.quit()
    print("End of code")
