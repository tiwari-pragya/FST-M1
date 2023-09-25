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
    driver.get("https://v1.training-support.net/selenium/ajax")
    print("Title of page is: " + driver.title)
    wait = WebDriverWait(driver, 10)

    # perform activity
    driver.find_element(By.XPATH, "//*[@class=\"ui violet button\"]").click()
    wait.until(expected_conditions.text_to_be_present_in_element((By.TAG_NAME, "h1"), "HELLO!"))
    message = driver.find_element(By.TAG_NAME, "h1").text
    print(message)
    message = driver.find_element(By.XPATH, "//*[@id=\"ajax-content\"]/h3").text
    print(message)

    wait.until(expected_conditions.text_to_be_present_in_element((By.TAG_NAME, "h3"), "I'm late!"))
    late_text = driver.find_element(By.XPATH, "//*[@id=\"ajax-content\"]/h3").text
    print(late_text)

    driver.quit()
    print("End of code")
