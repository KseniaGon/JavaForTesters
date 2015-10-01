package com.example.tests;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactCreateTest {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void test2() throws Exception {
    driver.get(baseUrl + "/addressbookv4.1.4/");
    driver.findElement(By.linkText("add new")).click();
    driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys("Test 2");
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys("Address 2");
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys("Last Name 2");
    driver.findElement(By.name("address")).clear();
    driver.findElement(By.name("address")).sendKeys("Address 2");
    driver.findElement(By.name("home")).clear();
    driver.findElement(By.name("home")).sendKeys("1234567890");
    driver.findElement(By.name("mobile")).clear();
    driver.findElement(By.name("mobile")).sendKeys("1234567890");
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("test2@test.com");
    new Select(driver.findElement(By.name("bday"))).selectByVisibleText("3");
    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText("February");
    driver.findElement(By.name("byear")).clear();
    driver.findElement(By.name("byear")).sendKeys("1980");
    new Select(driver.findElement(By.name("new_group"))).selectByVisibleText("Test1");
    driver.findElement(By.name("submit")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
