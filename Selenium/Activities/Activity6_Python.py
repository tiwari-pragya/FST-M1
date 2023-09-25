from selenium import webdriver
from selenium.webdriver import ActionChains, Keys
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
    action.send_keys("P").key_down(Keys.CONTROL).send_keys("a").key_up(Keys.CONTROL).key_down(Keys.CONTROL).send_keys("c").key_up(Keys.CONTROL).perform()

    driver.quit()
    print("End of code")
