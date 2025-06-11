package Week5Day2

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

object MVP1 extends App {

  val driver: WebDriver = new ChromeDriver()

  driver.get("https://demoqa.com/browser-windows")

  // Fetch and print: Page title
  val title = driver.getTitle
  println(s"The title is: $title")

  // Fetch and print: Current URL
  val currentUrl = driver.getCurrentUrl
  println(s"The Current URL is: $currentUrl")

  // Close current window
  driver.close()

  // End the session ( a bit redundant here )
  driver.quit()
}
