import time

import keyboard
from selenium import webdriver
from selenium.webdriver import ActionChains, Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.select import Select
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager

# setup firefox driver
service1 = FirefoxService(GeckoDriverManager().install())

# start driver
with webdriver.Firefox(service=service1) as driver:

    driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login")
    print("Title of page is: " + driver.title)
    wait = WebDriverWait(driver, 10)
    action = ActionChains(driver)

    # login to site
    driver.find_element(By.ID, "txtUsername").send_keys("orange")
    driver.find_element(By.ID, "txtPassword").send_keys("orangepassword123")
    driver.find_element(By.ID, "btnLogin").click()
    time.sleep(2)
    # wait.until(expected_conditions.visibility_of(By.XPATH("//*[@id = \"menu_dashboard_index\"]")))
    dashboardSelected = driver.find_element(By.XPATH, "//*[@id = \"menu_dashboard_index\"]").is_displayed()
    assert dashboardSelected == True, "User not on homepage."
    print("User Logged in Successfully")

    # edit employee
    driver.find_element(By.ID, "menu_pim_viewMyDetails").click()
    driver.find_element(By.XPATH, "//*[@id=\"menu_pim_viewMyDetails\"]/b").click()
    driver.find_element(By.ID, "btnSave").click()

    time.sleep(2)
    # wait.until(expected_conditions.element_to_be_clickable(By.ID("personal_txtEmpFirstName")))
    driver.find_element(By.ID, "personal_txtEmpFirstName").clear()
    driver.find_element(By.ID, "personal_txtEmpLastName").clear()
    driver.find_element(By.ID, "personal_txtEmpFirstName").send_keys("First Name")
    driver.find_element(By.ID, "personal_txtEmpLastName").send_keys("Last Name")
    driver.find_element(By.ID, "personal_optGender_2").click()
    nationality = driver.find_element(By.ID, "personal_cmbNation")
    select = Select(nationality)
    select.select_by_visible_text("Indian")
    driver.find_element(By.ID, "personal_DOB").clear()
    driver.find_element(By.ID, "personal_DOB").click()
    driver.find_element(By.ID, "personal_DOB").send_keys("2023-08-31")
    driver.find_element(By.ID, "personal_txtEmpFirstName").click()
    driver.find_element(By.ID, "btnSave").click()
    print("Details added successfully")

    # quit driver
    driver.quit()

    print("End of Activity")
