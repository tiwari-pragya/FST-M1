from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# setup firefox driver
service1 = FirefoxService(GeckoDriverManager().install())

# start driver
with webdriver.Firefox(service=service1) as driver:

    # perform activity 1
    driver.get("https://v1.training-support.net/")
    print("Title of page is: " + driver.title)
    driver.find_element(By.XPATH, "//*[@id=\"about-link\"]").click()
    print("Title of new page is: " + driver.title)

    # perform activity 2
    driver.get("https://v1.training-support.net/selenium/login-form")
    print("Title of page is: " + driver.title)
    driver.find_element(By.XPATH, "//*[@id=\"username\"]").send_keys("admin")
    driver.find_element(By.XPATH, "//*[@id=\"password\"]").send_keys("password")

    driver.find_element(By.XPATH, "//*[@class=\"ui button\"]").click()

    message = driver.find_element(By.ID, "action-confirmation")
    print("Login message: ", message.text)

    driver.quit()
    print("End of code")
