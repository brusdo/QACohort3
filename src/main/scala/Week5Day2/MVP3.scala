package Week5Day2

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

object MVP3 extends App {

  // Instantiating the ChromeDriver for interacting with the Chrome browser
  val driver: WebDriver = new ChromeDriver()

  // Accessing the web url for testing
  driver.get("https://demoqa.com/automation-practice-form")


//  driver.quit()
}
