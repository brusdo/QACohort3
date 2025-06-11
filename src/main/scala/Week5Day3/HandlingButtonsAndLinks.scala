package Week5Day3

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.WebElement

object HandlingButtonsAndLinks extends App {

  // Instantiating the ChromeDriver for interacting with the Chrome browser
  val driver: WebDriver = new ChromeDriver()

  // Accessing the web url for testing
  driver.get("https://www.selenium.dev/selenium/web/web-form.html")

  driver.manage().window().maximize()

  //Handling buttons

  val button = driver.findElement(By.cssSelector("[type=\"submit\"]"))

  if (button.isEnabled) {
    println("Button text: " + button.getText)
    button.click()
  } else {
    println("Button is not enabled")
  }

  //Handling hyperlinks

  driver.get("https://www.selenium.dev/")
  val myLink = driver.findElement(By.linkText("Documentation"))
  println("Get 'href' attribute for destination url: " + myLink.getAttribute("href"))

  driver.quit()

}