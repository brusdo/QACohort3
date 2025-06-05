package Automation.Week4Day4

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver, WebElement}

object LocatorsAfternoonTask extends App {

  // Instantiating the ChromeDriver for interacting with the Chrome browser
  val driver: WebDriver = new ChromeDriver()

  // Accessing the web url for testing
  // 1. Find by ID:
  driver.get("https://www.selenium.dev/selenium/web/web-form.html")
  val textInput: WebElement = driver.findElement(By.id("my-text-id"))
  textInput.sendKeys("Alice")
  println("Task 1. Text Input: Alice")

  // 2. Find by Name:
  val password: WebElement = driver.findElement(By.name("my-password"))
  password.sendKeys("12345")
  println("Task 2. Password: 12345")

  // 3. Find by Class Name:
  val textArea: WebElement = driver.findElement(By.name("my-textarea"))
  textArea.sendKeys("This is a test comment")
  println("Task 3. This is a test comment")
  // or "driver.findElement(By.className("form-control"))" less precise

  // 4. Find by Tag Name:
  val inputs = driver.findElements(By.tagName("input"))
  println(s"Task 4. Number of <input> elements: ${inputs.size()}")

  // 5. By LinkText
  val link: WebElement = driver.findElement(By.linkText("Return to index"))
  link.click()
  println("Task 5. Clicked 'Return to index' ")

  // 6. By PartialLinkText
  driver.navigate().back()
  val partialLink = driver.findElement(By.partialLinkText("Return"))
  partialLink.click()
  println("Task 6. Clicked link using partial link text 'Return'")

  driver.quit()

}

