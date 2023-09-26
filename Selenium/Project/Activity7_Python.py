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

    # add qualification details
    driver.find_element(By.ID, "menu_pim_viewMyDetails").click()
    driver.find_element(By.XPATH, "//*[@id=\"menu_pim_viewMyDetails\"]/b").click()

    time.sleep(2)
    # wait.until(expected_conditions.element_to_be_clickable(By.XPATH(" //*[@id=\"sidenav\"]/li[9]/a")))
    driver.find_element(By.XPATH, " //*[@id=\"sidenav\"]/li[9]/a").click()

    time.sleep(2)
    # wait.until(expected_conditions.element_to_be_clickable(By.XPATH("//*[@id =\"addWorkExperience\"]")))
    driver.find_element(By.XPATH, "//*[@id =\"addWorkExperience\"]").click()

    time.sleep(2)
    # wait.until(expected_conditions.element_to_be_clickable(By.ID("btnWorkExpSave")))
    driver.find_element(By.ID, "experience_employer").send_keys("testemployer")
    driver.find_element(By.ID, "experience_jobtitle").send_keys("test_job")
    driver.find_element(By.ID, "btnWorkExpSave").click()

    # quit driver
    driver.quit()

    print("End of Activity")
