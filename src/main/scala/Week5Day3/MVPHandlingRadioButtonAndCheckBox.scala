package Week5Day3

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver, WebElement}

object MVPHandlingRadioButtonAndCheckBox extends App {

  // Instantiating the ChromeDriver for interacting with the Chrome browser
  val driver: WebDriver = new ChromeDriver()

  // ---- 1. Navigate to the site and maximise it ----
  driver.get("https://testpages.herokuapp.com/styled/index.html")
  driver.manage().window().maximize()
  println("Task 1. Maximised the Page ✨")

  // ---- 2. Handle Text Boxes ----
    // Go to the "HTML Form Example" page
  val formExample = driver.findElement(By.xpath("//*[@id=\"htmlformtest\"]")).click()
  println("Task 2. Clicked on Basic HTML Form Example")

    // Fill in the username and password fields
  val username: WebElement = driver.findElement(By.name("username"))
  username.sendKeys("Bruna")
  println("Task 2. Added Username: Bruna")

  val password: WebElement = driver.findElement(By.name("password"))
  password.sendKeys("12345")
  println("Task 2. Added Password: 12345")

  // ---- 3. Handle Checkbox ----
    // Locate a checkbox
  //  val checkbox2 = driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[5]/td/input[2]"))
  val checkbox2 = driver.findElement(By.cssSelector("input[type='checkbox'][value='cb2']"))
  // <input type="checkbox" name="checkboxes[]" value="cb2">

  // Select the checkbox located if not already selected
  if(!checkbox2.isSelected) {
    checkbox2.click()
    println("Task 3. checkbox2 not selected - Selected it now")
  } else {
    println("Task 3. checkbox2 already selected")
  }

  // ---- 4. Handle Radio Buttons ----
    // Select a radio option
  val radio3 = driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[6]/td/input[3]"))

  // Select radio3 if not already selected
  if(!radio3.isSelected) {
    radio3.click()
    println("Task 4. radio3 not selected - Selected it now")
  } else {
    println("Task 4. radio3 already selected")
  }

  // ---- 5. Handle Dropdown/Select ----
    // Choose an option from the dropdown
  val item1 = driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[7]/td/select/option[1]"))

  // Select radio3 if not already selected
  if(!item1.isSelected) {
    item1.click()
    println("Task 5. item1 not selected - Selected it now")
  } else {
    println("Task 5. item1 already selected")
  }

  // ---- 6. Handle Buttons ----
    // Click the "Submit" button
  driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[9]/td/input[2]")).click()
  println("Task 6. Submitted Basic HTML Form Example")

  // ---- 7. Handle Links ----
    // Click a link to return to the homepage
  val indexLink = driver.findElement(By.linkText("Index"))
  indexLink.click()
  println("7. All done. Returned to Home Page")

  driver.quit()
}
