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

    # Get Emergency Contact
    driver.find_element(By.ID, "menu_pim_viewMyDetails").click()
    driver.find_element(By.XPATH, "//*[@id=\"menu_pim_viewMyDetails\"]/b").click()

    time.sleep(2)
    # wait.until(expected_conditions.element_to_be_clickable(By.XPATH(" //*[@id=\"sidenav\"]/li[3]/a")))
    driver.find_element(By.XPATH, " //*[@id=\"sidenav\"]/li[3]/a").click()

    time.sleep(2)
    # wait.until(expected_conditions.visibility_of_element_located(By.ID("emgcontact_list")))
    table_data = driver.find_elements(By.XPATH, "//*[@id = \"emgcontact_list\"]/thead/tr/th")
    print("Header Values: ")
    for cell in table_data:
        print(cell.text)

    table_data = driver.find_elements(By.XPATH, "//*[@id = \"emgcontact_list\"]/tbody/tr")
    for row in table_data:
        columns = row.find_elements(By.TAG_NAME, "td")
        # print content of cell
        for cell in columns:
            print(cell.text)

    # quit driver
    driver.quit()

    print("End of Activity")
