import time

import keyboard
from selenium import webdriver
from selenium.webdriver import ActionChains, Keys
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
    action = ActionChains(driver)
    fname = "Mike"
    lname = "Taylor"
    full = "Mike Taylor"
    employeeID = ""

    # login to site
    driver.find_element(By.ID, "txtUsername").send_keys("orange")
    driver.find_element(By.ID, "txtPassword").send_keys("orangepassword123")
    driver.find_element(By.ID, "btnLogin").click()
    time.sleep(2)
    # wait.until(expected_conditions.visibility_of(By.XPATH("//*[@id = \"menu_dashboard_index\"]")))
    dashboardSelected = driver.find_element(By.XPATH, "//*[@id = \"menu_dashboard_index\"]").is_displayed()
    assert dashboardSelected == True, "User not on homepage."
    print("User Logged in Successfully")

    # add employee
    driver.find_element(By.ID, "menu_pim_viewPimModule").click()
    driver.find_element(By.ID, "menu_pim_viewEmployeeList").click()
    time.sleep(2)
    # wait.until(expected_conditions.visibility_of(By.ID("btnAdd")))
    driver.find_element(By.ID, "btnAdd").click()
    # wait.until(expected_conditions.visibility_of(By.ID("firstName")))
    time.sleep(2)
    # wait.until(expected_conditions.element_to_be_clickable(By.ID("firstName")))
    driver.find_element(By.ID, "firstName").send_keys(fname)
    driver.find_element(By.ID, "lastName").send_keys(lname)
    employeeID = driver.find_element(By.ID, "employeeId").get_attribute("value")
    print("Employee Id: " + employeeID)
    driver.find_element(By.ID, "btnSave").click()

    # validate employee added
    time.sleep(2)
    # wait.until(expected_conditions.visibility_of(By.ID("empPic")))
    driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/pim/viewEmployeeList")
    time.sleep(2)
    # wait.until(expected_conditions.element_to_be_clickable(By.ID("searchBtn")))
    employeeName = driver.find_element(By.ID, "empsearch_employee_name_empName")
    employeeName.click()
    employeeName.clear()
    employeeName.send_keys(full)
    employeeName.send_keys(Keys.TAB)
    time.sleep(2)
    # action.key_down(Keys.TAB).key_up(Keys.TAB).perform()
    # action.send_keys(Keys.TAB)
    driver.find_element(By.ID, "empsearch_id").send_keys(employeeID)
    driver.find_element(By.ID, "searchBtn").click()
    idData = driver.find_elements(By.XPATH, "//*[@id=\"resultTable\"]/tbody/tr/td[2]")
    resultPresent = "false"
    for eid in idData:
        if eid.text == employeeID:
            resultPresent = "true"
            break

    assert resultPresent == "true", "Employee not added."

    # quit driver
    driver.quit()

    print("End of Activity")
