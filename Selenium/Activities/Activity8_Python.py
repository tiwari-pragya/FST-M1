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
    # open webpage
    driver.get("https://v1.training-support.net/selenium/dynamic-controls")

    # Initialize wait
    wait = WebDriverWait(driver, 10)

    # get title of page and print to console
    print("Title of page is: " + driver.title)

    # perform activity
    button = driver.find_element(By.ID, "toggleCheckbox")
    checkbox = driver.find_element(By.XPATH, "//*[@id=\"dynamicCheckbox\"]/input")
    checkbox.click()
    button.click()
    wait.until(expected_conditions.invisibility_of_element(checkbox))

    button.click()
    wait.until(expected_conditions.visibility_of(checkbox))
    checkbox.click()

    # quit driver
    driver.quit()

    print("End of code")
