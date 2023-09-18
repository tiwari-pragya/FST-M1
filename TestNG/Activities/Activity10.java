package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Activity10 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeMethod(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://v1.training-support.net/selenium/simple-form");

    }

    @AfterClass
    public void afterMethod(){

        driver.quit();
    }

    public static List<List<Object>> readFromExcel(String filePath) {
        List<List<Object>> data = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            for (Row row: sheet) {
                List<Object> rowData = new ArrayList<>();
                for(Cell cell: row) {
                    if(cell != null) {
                        switch (cell.getCellType()) {
                            case STRING -> rowData.add(cell.getStringCellValue());
                            case NUMERIC -> rowData.add(cell.getNumericCellValue());
                            case BOOLEAN -> rowData.add(cell.getBooleanCellValue());
                        }
                    }
                }
                data.add(rowData);
            }
            file.close();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    @DataProvider(name = "Registration")
    public static Object[][] signUpInfo() {
        String filePath = "src/test/resources/Activity10_Input.xlsx";
        List<List<Object>> data = readFromExcel(filePath);
        return new Object[][] {
                { data.get(1) },
                { data.get(2) },
                { data.get(3) },
        };
    }

    @Test(dataProvider = "Registration")
    public void registrationTest(List<Object> rows) {
        WebElement firstNameField = driver.findElement(By.id("firstName"));
        WebElement lastNameField = driver.findElement(By.id("lastName"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement phoneNumberField = driver.findElement(By.id("number"));

        firstNameField.clear();
        lastNameField.clear();
        emailField.clear();
        phoneNumberField.clear();

        firstNameField.sendKeys(rows.get(1).toString());
        lastNameField.sendKeys(rows.get(2).toString());
        emailField.sendKeys(rows.get(3).toString());
        phoneNumberField.sendKeys(rows.get(4).toString());

        driver.findElement(By.xpath("//*[@class=\"ui green button\"]")).click();
        wait.until(ExpectedConditions.alertIsPresent());

        Alert message = driver.switchTo().alert();
        System.out.println("Alert Message: " + message.getText());
        Reporter.log("Alert Message: " + message.getText());
        message.accept();

        driver.navigate().refresh();
    }

}
