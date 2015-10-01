package com.example.tests;

import org.testng.annotations.Test;
import org.openqa.selenium.*;

public class GroupCreationTest extends TestBase {
  @Test
  public void createGroup() throws Exception {
    driver.findElement(By.linkText("groups")).click();
    driver.findElement(By.name("new")).click();
    driver.findElement(By.name("group_name")).clear();
    driver.findElement(By.name("group_name")).sendKeys("Test1");
    driver.findElement(By.name("group_header")).clear();
    driver.findElement(By.name("group_header")).sendKeys("Test header 1");
    driver.findElement(By.name("group_footer")).clear();
    driver.findElement(By.name("group_footer")).sendKeys("Test footer 1");
    driver.findElement(By.name("submit")).click();
  }
}
