from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# setup firefox driver
service1 = FirefoxService(GeckoDriverManager().install())

# start driver
with webdriver.Firefox(service=service1) as driver:

    driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login")
    # driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php")
    print("Title of page is: " + driver.title)

    url = driver.find_element(By.XPATH, "//*[@id=\"divLogo\"]/img").get_attribute("src")
    print("URL of image is: " + url)

    # quit driver
    driver.quit()

    print("End of Activity")
