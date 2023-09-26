from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# setup firefox driver
service1 = FirefoxService(GeckoDriverManager().install())

# start driver
with webdriver.Firefox(service=service1) as driver:

    driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login")
    # driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php")
    page_title = driver.title
    print("Title of page is: " + page_title)

    assert page_title == "OrangeHRM", "Title doesn't match"

    # quit driver
    driver.quit()

    print("End of Activity")
