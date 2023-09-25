from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# setup firefox driver
service1 = FirefoxService(GeckoDriverManager().install())

# start driver
with webdriver.Firefox(service=service1) as driver:
    # open webpage and print title
    driver.get("https://v1.training-support.net/selenium/input-events")
    print("Title of page is: " + driver.title)
    action = ActionChains(driver)

    # perform activity
    # Perform left click
    action.click().perform()
    curr_text = driver.find_element(By.CLASS_NAME, "active")
    print("Value of side after left click: ", curr_text.text)

    # Perform double click
    action.double_click().perform()
    curr_text = driver.find_element(By.CLASS_NAME, "active")
    print("Value of side after double click: ", curr_text.text)

    # Perform right click
    action.context_click().perform()
    curr_text = driver.find_element(By.CLASS_NAME, "active")
    print("Value of side after right click: ", curr_text.text)

    driver.quit()
    print("End of code")
