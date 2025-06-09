package Automation.Week5Day1

import Automation.Week4Day4.LocatorsAfternoonTask.driver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver, WebElement}

object MonAfternoonTaskLocator extends App {
  val driver: WebDriver = new ChromeDriver
  //  1. Navigates to the above Test web URL
  driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html")
  println("Task 1. Web URL is working")

  //  2. Enters text into:
  //    A username field (using By.name strategy)
  val username: WebElement = driver.findElement(By.name("username"))
  username.sendKeys("Bruna")
  println("Task 2a. Username: Bruna")

  //    A password field (using cssSelector By Partial Attribute Expression)
  val password: WebElement = driver.findElement(By.cssSelector("input[name='password']"))
  password.sendKeys("12345")
  println("Task 2b. Password: 12345")
  // <input type="password" name="password" size="15">

  //    A comments/extra field (Using the CtrlC+CtrlV Selector)
  val text: WebElement = driver.findElement(By.cssSelector("#HTMLFormElements > table > tbody > tr:nth-child(3) > td > textarea"))
  text.sendKeys("My Comment")
  println("Task 2c. Text Area: My Comment")

  //  3. Clicks on:
  //    A checkbox (XPath)
  val checkbox: WebElement = driver.findElement(By.xpath("//input[@value='cb1']"))
  checkbox.click()
  println("Task 3a. Clicked checkbox 1")
  // <input type="checkbox" name="checkboxes[]" value="cb1">

  //    A submit button (className)
  val submit: WebElement = driver.findElement(By.className("styled-click-button"))
  submit.click()
  println("Task 3b. Clicked Submit btn")
  //<input type="submit" name="submitbutton" value="submit" class="styled-click-button">

  //    A link on the page
  val link: WebElement = driver.findElement(By.className("styled-click-button"))
  link.click()
  println("Task 3b. Clicked a Link")



//  driver.quit()
}


//  3. Clicks on:
//    A checkbox
//    A submit button
//    A link on the page
//  4. Use a different locator strategy for EACH action:
//    One action must use `id`
//    One must use `name`
//    One must use `className`
//    One must use `tagName`
//    One must use `cssSelector`
//    One must use `xpath`
//    One must use `linkText`
//    One must use `partialLinkText`