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
    driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login")
    # driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web")
    print("Title of page is: " + driver.title)
    wait = WebDriverWait(driver, 10)

    driver.find_element(By.ID, "txtUsername").send_keys("orange")
    driver.find_element(By.ID, "txtPassword").send_keys("orangepassword123")
    driver.find_element(By.ID, "btnLogin").click()

    # wait.until(expected_conditions.visibility_of_all_elements_located(By.XPATH("//*[@id = \"menu_dashboard_index\"]")))
    time.sleep(2)
    dashboardSelected = driver.find_element(By.XPATH, "//*[@id = \"menu_dashboard_index\"]").is_displayed()
    print(dashboardSelected)
    assert dashboardSelected == True, "User not on homepage."
    print("User Logged in Successfully")

    # quit driver
    driver.quit()

    print("End of Activity")
