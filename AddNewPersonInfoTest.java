package ru.geekbrains.HomeWork3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AddNewPersonInfoTest {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginToShop();

        driver.findElement(By.xpath("//a[@title='Information']")).click();
        driver.findElement(By.id("firstname")).clear();
        driver.findElement(By.id("firstname")).sendKeys("Ivan");
        Select daysSelect = new Select(driver.findElement(By.id("days")));
        daysSelect.selectByVisibleText("12  ");
        Select monthSelect = new Select(driver.findElement(By.id("months")));
        monthSelect.selectByVisibleText("June ");
        Select yearsSelect = new Select(driver.findElement(By.id("years")));
        yearsSelect.selectByVisibleText("2000  ");
        driver.findElement(By.id("old_passwd")).sendKeys("123456");
        driver.findElement(By.xpath("//span[text()='Save']/..")).click();

        Thread.sleep(5000);

        driver.quit();
    }
    public static void loginToShop() {
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
        driver.findElement(By.id("email")).sendKeys("lion@list.ru");
        driver.findElement(By.id("passwd")).sendKeys("123456");
        driver.findElement(By.id("SubmitLogin")).click();
    }
}
