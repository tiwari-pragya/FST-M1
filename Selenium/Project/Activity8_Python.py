import time

from selenium import webdriver
from selenium.webdriver import Keys
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

    # login to site
    driver.find_element(By.ID, "txtUsername").send_keys("orange")
    driver.find_element(By.ID, "txtPassword").send_keys("orangepassword123")
    driver.find_element(By.ID, "btnLogin").click()
    time.sleep(2)
    # wait.until(expected_conditions.visibility_of(By.XPATH("//*[@id = \"menu_dashboard_index\"]")))
    dashboard_selected = driver.find_element(By.XPATH, "//*[@id = \"menu_dashboard_index\"]").is_displayed()
    assert dashboard_selected == True, "User not on homepage."
    print("User Logged in Successfully")

    # Apply leave
    driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/leave/applyLeave")
    time.sleep(2)
    # wait.until(expected_conditions.element_to_be_clickable(By.ID("applyleave_txtLeaveType")))
    leave_type = driver.find_element(By.ID, "applyleave_txtLeaveType")
    select = Select(leave_type)
    select.select_by_visible_text("DayOff")
    from_date = driver.find_element(By.ID, "applyleave_txtFromDate")
    to_date = driver.find_element(By.ID, "applyleave_txtToDate")
    from_date.clear()
    from_date.send_keys("2023-11-02")
    from_date.send_keys(Keys.TAB)
    to_date.clear()
    to_date.send_keys("2023-11-02")
    to_date.send_keys(Keys.TAB)
    driver.find_element(By.ID, "applyBtn").click()
    time.sleep(2)

    # check leave status
    driver.find_element(By.ID, "menu_leave_viewMyLeaveList").click()
    time.sleep(2)
    # wait.until(expected_conditions.element_to_be_clickable(By.ID("calFromDate")))
    from_date = driver.find_element(By.ID, "calFromDate")
    to_date = driver.find_element(By.ID, "calToDate")
    from_date.clear()
    from_date.send_keys("2023-11-02")
    from_date.send_keys(Keys.TAB)
    to_date.clear()
    to_date.send_keys("2023-11-02")
    to_date.send_keys(Keys.TAB)
    driver.find_element(By.ID, "btnSearch").click()
    data = driver.find_element(By.XPATH, "//*[@id=\"resultTable\"]/tbody/tr/td[6]").text
    print("Status of leave: " + data)
    assert data == "Pending Approval(1.00)", "Status mismatch"

    # quit driver
    driver.quit()

    print("End of Activity")
