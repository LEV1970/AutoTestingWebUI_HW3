package ru.geekbrains.HomeWork3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AddNewAddressTest {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginToShop();

        driver.findElement(By.xpath("//a[@title='Addresses']")).click();
        driver.findElement(By.xpath("//a[@title='Add an address']")).click();
        driver.findElement(By.id("address1")).sendKeys("Red Square");
        driver.findElement(By.id("city")).sendKeys("Moscow");
        Select stateSelect = new Select(driver.findElement(By.id("id_state")));
        stateSelect.selectByVisibleText("Florida");
        driver.findElement(By.id("postcode")).sendKeys("12345");
        driver.findElement(By.id("phone")).sendKeys("1234567890");
        driver.findElement(By.id("phone_mobile")).sendKeys("9876543210");
        driver.findElement(By.id("submitAddress")).click();

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
