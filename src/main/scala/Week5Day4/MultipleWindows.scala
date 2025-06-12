package Week5Day4

import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver

import scala.jdk.CollectionConverters.CollectionHasAsScala

object MultipleWindows extends App {

  // Instantiating the ChromeDriver for interacting with the Chrome browser
  val driver = new ChromeDriver()

  // Accessing the web url for testing
  driver.get("https://the-internet.herokuapp.com/windows")

  // What is a Window Handle?
  // A window handle is a unique alphanumeric string (like a session ID) assigned by the browser
  // to each open window or tab.

  // Maximise the browser window for better visibility and interaction
  driver.manage().window().maximize()

  // Store the handle (ID) of the current (parent) window
  val parentWindow = driver.getWindowHandle() //get the handle for the parent window
  println("Handle for the parent window: " + parentWindow)

  // Find the link with the text "Click Here" and click it
  // This action is expected to open a new window or tab
  driver.findElement(By.linkText("Click Here")).click()

  // Get a list of all currently open window handles (IDs)
  // Convert the Java Set to a Scala List for easier iteration
  val allWindows: List[String] = driver.getWindowHandles.asScala.toList

  // Create an iterator to loop through all window handles
  val it = allWindows.iterator

  // Iterate through all window handles
  while (it.hasNext) {
    val handle = it.next()

    // Check if the handle is NOT the parent window
    // This identifies the newly opened child window
    if (handle != parentWindow) {
      // Switch the driver's context to the new window
      driver.switchTo().window(handle)
      println("The current window: " + handle)

      // Print the title of the newly opened window
      println("The page title is - " + driver.getTitle())
    }
  }

  // Switch back to parent window
  driver.switchTo().window(parentWindow)
  println("Switched back to Parent Window")

  driver.quit()

}
