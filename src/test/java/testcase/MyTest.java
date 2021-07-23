package testcase;

import mypackage.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyTest {

  @BeforeMethod()
  public void beforeMethod() {
    WebDriverManager.chromedriver().setup();
    DriverManager.setDriver(new ChromeDriver());
  }

  @AfterMethod()
  public void closeBrowser() {
    DriverManager.quitDriver();
  }

  @Test(description = "This test passes")
  public void withoutTimeOut() {
    DriverManager.getDriver().navigate().to("https://www.google.com");
  }

  @Test(timeOut = 100000, description = "This test fails")
  public void withTimeOut() {
    DriverManager.getDriver().navigate().to("https://www.google.com");
  }
}
