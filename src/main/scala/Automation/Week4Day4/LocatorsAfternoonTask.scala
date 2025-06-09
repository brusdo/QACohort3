package Automation.Week4Day4

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver, WebElement}

object LocatorsAfternoonTask extends App {

  // Instantiating the ChromeDriver for interacting with the Chrome browser
  val driver: WebDriver = new ChromeDriver()

  // Accessing the web url for testing
  driver.get("https://www.selenium.dev/selenium/web/web-form.html")

  // 1. Find by ID: Locate the text input id locator and enter any name (e.g. Alice)
  val textInput: WebElement = driver.findElement(By.id("my-text-id"))
  textInput.sendKeys("Alice")
  println("Task 1. Text Input: Alice")

  // 2. Find by Name: Locate the text password field using name locator, and enter any password (e.g. 12345)
  val password: WebElement = driver.findElement(By.name("my-password"))
  password.sendKeys("12345")
  println("Task 2. Password: 12345")

  // 3. Find by Class Name: Locate the text area using class name locator and enter text line "This is a test comment"
  val textArea: WebElement = driver.findElement(By.name("my-textarea"))
//  val textArea: WebElement = driver.findElement(By.className("form-control"))
  textArea.sendKeys("This is a test comment")
  println("Task 3. This is a test comment")
  // or "driver.findElement(By.className("form-control"))" less precise

  // 4. Find by Tag Name: Locate all <input> elements and print how many are present on the page
  val inputs = driver.findElements(By.tagName("input"))
  println(s"Task 4. Number of <input> elements: ${inputs.size()}")

  // 5. By LinkText: Click on the link with full text "Return to index" (at the bottom of the form)
  val link: WebElement = driver.findElement(By.linkText("Return to index"))
  link.click()
  println("Task 5. Clicked 'Return to index' ")

  // 6. By PartialLinkText: Navigate back to the form page and locate the same link using "Return" (partial text), then click i again
  driver.navigate().back()
  val partialLink = driver.findElement(By.partialLinkText("Return"))
  partialLink.click()
  println("Task 6. Clicked link using partial link text 'Return'")

//  driver.quit()

}

