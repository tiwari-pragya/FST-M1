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
    username = driver.find_element(By.XPATH, "//*[contains(@class, '-username')]")
    password = driver.find_element(By.XPATH, "//*[contains(@class, '-password')]")
    cnfrPass = driver.find_element(By.XPATH, "//*[contains(@class, '-password')]/following::input")
    email = driver.find_element(By.XPATH, "//*[contains(@class, 'email-')]")
    signUpBtn = driver.find_element(By.XPATH, "//*[contains(@class, '-password')]/following::button")

    username.send_keys("test15_09_2023")
    password.send_keys("qwerty@12345")
    cnfrPass.send_keys("qwerty@12345")
    email.send_keys("test15_09_2023@gmail.com")
    signUpBtn.click()

    # wait for login message and print
    conf_id = driver.find_element(By.ID, "action-confirmation")
    wait.until(expected_conditions.visibility_of(conf_id))
    message = driver.find_element(By.ID, "action-confirmation").text
    print("Login message: " + message)

    driver.quit()
    print("End of code")
