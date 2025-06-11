package Week5Day2

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

object MVP2 extends App {

  val driver: WebDriver = new ChromeDriver()

  driver.get("https://demoqa.com/automation-practice-form")

  driver.navigate().to("https://example.com")

  driver.navigate().back()

  driver.navigate().forward()

  driver.navigate().refresh()

  driver.manage().window().maximize()

  driver.manage().window().minimize()

  val pageSource = driver.getPageSource
//  println(s"Full HTML source: $pageSource")
  println(s"First 200 characters:\n" + pageSource.take(200))

  driver.close()

  driver.quit()
}
