package Week5Day4

// Import necessary Selenium classes
import org.openqa.selenium.{By, WebElement}
import org.openqa.selenium.chrome.ChromeDriver
import java.util
import scala.jdk.CollectionConverters.CollectionHasAsScala

// Define a singleton object with main method
object AprilLoopPractice extends App {

  // For comprehension
  /**
    * for (item <- collection){
   * //DO SOMETHING TO EVERY ITEM
   * }
  */

  val fruits: List[String] = List("Apple", "Banana", "Cherry", "Melon")

  for(fruit <- fruits){
    println(fruit)
  }

  //TURNED INTO SELENIUM:
  /**
   * //.asScala -> turn it into Scala from Java
   * for (fruit <- fruits.asScala){
   * println(fruit.getText)
   * }
   */

  //EXAMPLE - WON'T RUN
  val driver = new ChromeDriver()
  driver.get("https//example.com")

  //Loop through a List of Elements
  val items: util.List[WebElement] = driver.findElements(By.id("i")) // Elements with S if it is a List. Find element by inspect
  for (item <- items.asScala) { //Loop over each WebElement in the items collection (but this is a Java list
    // currently can't use the <- until we turn it into Scala).
    println(item.getText) //Get the text, and print it
  }

  //click all buttons within a selection
  val buttons = driver.findElements(By.cssSelector(".my-buttons"))
  for (button <- buttons.asScala){
    button.click()
  }

  //find a specific element (within a loop - collection of a type)
  //Need to use an 'if' within the FOR comp
  val links = driver.findElements(By.tagName("a")) //Find all the links on the URL from line 35
  //I want to find the 'contact us' link
  for(link <- links.asScala) {
    if (link.getText.contains("Contact".toLowerCase)){
      link.click()
    } else // You don't necessarily need an ELSE
      println("No Links containing 'Contact' were found.") // There are better ways
  }

//TABLES
//  <table>
//    <tr>
//      <td>Apple</td> <td>Red</td>
//    </tr>
//    <tr>
//      <td>Banana</td> <td>Yellow</td>
//    </tr>
//  </table>

  //Loop through table rows
  val rows = driver.findElements(By.tagName("tr")) //find all elements contained with 'tr' tags (rows)
  for ((row, index) <- rows.asScala.zipWithIndex){
    val cells = row.findElements(By.tagName("td")) // this is taking all of the rows that have been found,
    // going inside those rows, and pulling out every 'td' tag
    val makeString = cells.asScala.map(_.getText.mkString(" | ".trim)) // MakeString: format in between, NOT inside
    println(makeString) //To see it
  }

  //zipWithIndexMethod:
  //Pair each row with its index (starting from 0)
  //Row 0: Apple | Red
  //Row 1: Banana | Yellow

  // Does a value exist?
  val doesBananaExist = rows.asScala.exists{ row =>
    val cells = row.findElements(By.tagName("td")).asScala
    cells.exists(_.getText == "Banana")
  }
  assert(doesBananaExist, "Yay bananas!")
}