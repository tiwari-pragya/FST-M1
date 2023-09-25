from selenium import webdriver
from selenium.webdriver import ActionChains
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
    driver.get("https://v1.training-support.net/selenium/popups")
    print("Title of page is: " + driver.title)
    wait = WebDriverWait(driver, 10)

    # perform activity
    signin_button = driver.find_element(By.XPATH, "//*[@class=\"ui huge inverted orange button\"]")
    ActionChains(driver).move_to_element(signin_button).perform()
    tooltip_text = signin_button.get_attribute("data-tooltip")
    print("Tooltip text: ", tooltip_text)

    signin_button.click()

    username = driver.find_element(By.ID, "username")
    password = driver.find_element(By.ID, "password")
    login = driver.find_element(By.XPATH, "//*[@id=\"password\"]/following::button")

    username.send_keys("admin")
    password.send_keys("password")
    login.click()

    message = driver.find_element(By.ID, "action-confirmation")
    print("Text on screen: ", message.text)

    driver.quit()
    print("End of code")
