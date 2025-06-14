package Week5Day2

import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver

object MVP3 extends App {

  // Instantiating the ChromeDriver for interacting with the Chrome browser
  val driver: WebDriver = new ChromeDriver()

  // Accessing the web url for testing
  driver.get("https://demoqa.com/automation-practice-form")

  // 3. Locate elements:
  val firstName = driver.findElement(By.id("firstName"))

  val submitBtn = driver.findElement(By.id("submit"))

//  val readingCheckbox = driver.findElement(By.id("hobbies-checkbox-2"))
  val readingCheckbox = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']"))

  if(firstName.isDisplayed && firstName.isEnabled) {
    firstName.sendKeys("Bruna")
    println("First name is displayed and enabled and I typed 'Bruna' ")
  } else {
    println("First name is not displayed or enabled")
  }

  if(!readingCheckbox.isSelected) {
    readingCheckbox.click()
    println("Reading checkbox not selected - Selected it now")
  } else {
    println("Reading checkbox already selected")
  }

  if(submitBtn.isDisplayed && submitBtn.isEnabled) {
    submitBtn.click()
    println("Submitted")
  }

  driver.quit()
}


