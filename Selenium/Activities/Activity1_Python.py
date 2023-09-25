from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# setup firefox driver
service1 = FirefoxService(GeckoDriverManager().install())

# start driver
with webdriver.Firefox(service=service1) as driver:
    # open webpage
    driver.get("https://v1.training-support.net/")

    # get title of page and print to console
    print("Title of page is: " + driver.title)

    # perform activity
    driver.find_element(By.ID, "about-link").click()

    print("Title of new page is: " + driver.title)

    # quit driver
    driver.quit()

    print("End of code")
