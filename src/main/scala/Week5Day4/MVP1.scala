package Week5Day4

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, JavascriptExecutor, WebDriver}

import java.time.Duration

object MVP1 extends App {

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

    driver.quit()

}