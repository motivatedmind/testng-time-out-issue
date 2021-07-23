package mypackage;

import org.openqa.selenium.WebDriver;

public class DriverManager {

  private static final ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL = new ThreadLocal<>();

  private DriverManager() {
  }

  public static WebDriver getDriver() {
    return WEB_DRIVER_THREAD_LOCAL.get();
  }

  public static void setDriver(WebDriver driver) {
    WEB_DRIVER_THREAD_LOCAL.set(driver);
  }

  public static void quitDriver() {
    if (WEB_DRIVER_THREAD_LOCAL.get() != null) {
      WEB_DRIVER_THREAD_LOCAL.get().quit();
    }
  }

}
