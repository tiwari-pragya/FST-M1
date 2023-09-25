from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# setup firefox driver
service1 = FirefoxService(GeckoDriverManager().install())

# start driver
with webdriver.Firefox(service=service1) as driver:
    # open webpage
    driver.get("https://v1.training-support.net/selenium/login-form")

    # get title of page and print to console
    print("Title of page is: " + driver.title)

    # perform activity
    driver.find_element(By.ID, "username").send_keys("admin")
    driver.find_element(By.ID, "password").send_keys("password")

    # driver.find_element(By.CSS_SELECTOR, "button.button:nth-child(4)").click()
    driver.find_element(By.XPATH, "//*[@class=\"ui button\"]").click()

    message = driver.find_element(By.ID, "action-confirmation")
    print("Login message: ", message.text)

    driver.quit()
    print("End of code")
