package Week5Day4

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait, WebDriverWait}
import org.openqa.selenium.{By, JavascriptExecutor, WebDriver}
import org.openqa.selenium.NoSuchElementException

import java.time.Duration

object Extension extends App {

  val driver: WebDriver = new ChromeDriver()
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) //  3a. Set a global IMPLICIT WAIT of 10 seconds
  val js = driver.asInstanceOf[JavascriptExecutor] // 2c. Initialise js to HIGHLIGHT rows

  //   1. Navigate to the Practice Table URL
  driver.get("https://cosmocode.io/automation-practice-webtable/")

  // 2. Static Table Handling
  // 2a. Locate the table containing country data
  val table = driver.findElement(By.id("countries"))

  // 2b. Extract and print all country names from the first column
  val rows = table.findElements(By.tagName("tr"))

  for (i <- 1 until rows.size()) {
    val cells = rows.get(i).findElements(By.tagName("td"))
    js.executeScript("arguments[0].style.backgroundColor = '#42daf566'", rows.get(i)) // 2c Highlight rows! HEX works :)
    println(cells.get(0).getText)
  }

  //  4. Explicit Wait
  //  4a Wait for a specific country row (e.g., "Germany") to be visible
  val explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5))
  val brazil_tr = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"countries\"]/tbody/tr[25]")))
  js.executeScript("arguments[0].scrollIntoView()", brazil_tr)
  println("I can see Brazil 🇧🇷")

  // 4b Once visible, extract its capital and currency
  val tdsRow = brazil_tr.findElements(By.tagName("td"))
  val capital = tdsRow.get(1).getText
  val currency = tdsRow.get(2).getText
  println(s"Brazil's capital is: $capital")
  println(s"Brazil's currency is: $currency")


  // ------------ EXTENSION ------------
  //  1. JavaScript Executor
  //  1a. Scroll to the bottom of the page using JavaScript
  js.executeScript("window.scrollTo(0, document.body.scrollHeight);")
  println("Scrolled to bottom of page")

  //  1b. Change the background colour of the "Country" column header
  val headerCountry = driver.findElement(By.xpath("//*[@id=\"countries\"]/tbody/tr[1]/td[2]"))
  js.executeScript("arguments[0].style.backgroundColor = '#ffb6c1'", headerCountry)
  println("Changed the background colour of the Country Header")

  //  1c. Retrieve and print the page title using JavaScript.
  val titlePage = js.executeScript("return document.title")
  println(s"The Page Title is: $titlePage")
  //  driver.quit()

  //  2. Fluent Wait
  //  2a. Use Fluent Wait to wait for a specific row (e.g., "India") to become visible
  val fluentWait = new FluentWait[WebDriver](driver)
    .withTimeout(Duration.ofSeconds(10))
    //  2b. Set polling every 500ms, timeout after 15 seconds
    .pollingEvery(Duration.ofMillis(500))
//    .ignoring(classOf[NoSuchElementException])

  val maldivesRow = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"countries\"]/tbody/tr[109]/td[2]")))
    js.executeScript("arguments[0].scrollIntoView()", maldivesRow)
  println("Found Maldives")

//  3. Table Validation
//  3a. Write a test that verifies if a specific language (e.g., "French") is listed in the table
//  3b. Highlight the corresponding row if found
  var frenchLanguage = false
  for (i <- 1 until rows.size()) {
    val cells = rows.get(i).findElements(By.tagName("td"))
    if (cells.get(4).getText.contains("French")) {
      js.executeScript("arguments[0].style.backgroundColor = 'yellow'", rows.get(i))
      frenchLanguage = true
    }
  }
  if (frenchLanguage) {
    println("Highlighted all countries where French is the Primary language")
  } else {
    println("No countries found where French is the Primary language")
  }

  driver.quit()

}