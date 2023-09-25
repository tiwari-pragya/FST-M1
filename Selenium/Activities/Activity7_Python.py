from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# setup firefox driver
service1 = FirefoxService(GeckoDriverManager().install())

# start driver
with (webdriver.Firefox(service=service1) as driver):
    # open webpage and print title
    driver.get("https://v1.training-support.net/selenium/drag-drop")
    print("Title of page is: " + driver.title)
    action = ActionChains(driver)

    # perform activity
    ball = driver.find_element(By.ID, "draggable")
    dropzone1 = driver.find_element(By.ID, "droppable")
    dropzone2 = driver.find_element(By.ID, "dropzone2")

    action.drag_and_drop(ball, dropzone1).perform()
    if dropzone1.text.find("Dropped!"):
        print("Dropzone 1 was activated!")

    action.drag_and_drop(ball, dropzone2).perform()
    if dropzone2.text.find("Dropped!"):
        print("Dropzone 2 was activated!")

    print("Action performed successfully")
    driver.quit()
