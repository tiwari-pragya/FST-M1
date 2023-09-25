import time

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
    driver.get("https://v1.training-support.net/selenium/tab-opener")
    print("Title of page is: " + driver.title)
    wait = WebDriverWait(driver, 10)

    # perform activity
    print("Parent window handle: ", driver.current_window_handle)
    driver.find_element(By.ID, "launcher").click()

    wait.until(expected_conditions.number_of_windows_to_be(2))
    print("All window handles: ", driver.window_handles)

    driver.switch_to.window(driver.window_handles[1])

    print("Current window handle: ", driver.current_window_handle)
    wait.until(expected_conditions.title_contains("New"))
    print("New Tab title: ", driver.title)
    time.sleep(3)
    heading = driver.find_element(By.XPATH, "//*[@class=\"content\"]")
    print(heading.text)

    driver.find_element(By.ID, "actionButton").click()
    wait.until(expected_conditions.number_of_windows_to_be(3))
    print("All window handles: ", driver.window_handles)

    driver.switch_to.window(driver.window_handles[2])

    print("Current window handle: ", driver.current_window_handle)
    time.sleep(3)
    print("New Tab title: ", driver.title)
    heading = driver.find_element(By.XPATH, "//*[@class=\"content\"]")
    print(heading.text)

    driver.quit()
    print("End of code")
