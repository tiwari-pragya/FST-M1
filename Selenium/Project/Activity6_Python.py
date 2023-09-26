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
    print("Title of page is: " + driver.title)
    wait = WebDriverWait(driver, 10)

    # login to site
    driver.find_element(By.ID, "txtUsername").send_keys("orange")
    driver.find_element(By.ID, "txtPassword").send_keys("orangepassword123")
    driver.find_element(By.ID, "btnLogin").click()
    time.sleep(2)
    # wait.until(expected_conditions.visibility_of(By.XPATH("//*[@id = \"menu_dashboard_index\"]")))
    dashboard_selected = driver.find_element(By.XPATH, "//*[@id = \"menu_dashboard_index\"]").is_displayed()
    assert dashboard_selected == True, "User not on homepage."
    print("User Logged in Successfully")

    # check directory menu
    directory_menu = driver.find_element(By.XPATH, "//*[@id = \"menu_directory_viewDirectory\"]").is_displayed()
    assert directory_menu == True, "Directory Menu not available"
    driver.find_element(By.ID, "menu_directory_viewDirectory").click()
    driver.find_element(By.XPATH, "//*[@id=\"menu_directory_viewDirectory\"]/b").click()
    time.sleep(2)
    # wait.until(expected_conditions.visibility_of(By.XPATH("//*[@class=\"head\"]/h1")))
    page_text = driver.find_element(By.XPATH, "//*[@class=\"head\"]/h1").text
    assert page_text == "Search Directory", "Matching Text not found"
    print("Navigated to Directory Page successfully.")

    # quit driver
    driver.quit()

    print("End of Activity")
