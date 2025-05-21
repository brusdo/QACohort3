import scala.collection.SortedMap
import scala.collection.immutable.ListMap

object TueAfternoonTask extends App {

  // 1. Create a `Seq` of taxpayer forenames representing multiple submissions, including some duplicates. Store this `Seq` in a val.
  val nameSeq: Seq[String] = Seq("Bruna", "April", "Chad", "Andy", "Bruna", "April")

  // 2. Using string interpolation, print the full list of submissions.
  println("2. Set of Names: " + nameSeq)

  // 3. Write a method that uses the built-in method `.count` to identify how many times a specific taxpayer submitted
    // their tax returns in the `Seq` from question 1. This method should work for any inputted taxpayer.
  def countSubmissions(name: String): Int = {
    nameSeq.count(_ == name)
  }

  //NOTES: All 3 below are equivalent
//  def myFunction(name): Unit = {
//    return name == "Bruna"
//  }
//  OR
//  name => name == "Bruna" // Anonymous function
// OR
//  _ == "Bruna"

  // 4. Print a sentence that states how many times a specific person submitted their tax returns using your method for question 3.
  val count = countSubmissions("Bruna")
  println(f"4. Bruna submitted $count times")

  // 5. Using a built-in method (research will be required here), convert the `Seq` to a `Set` to remove duplicates.
  val nameSet = nameSeq.toSet

  // 6. Using string interpolation, print the list of unique taxpayers who submitted.
  println(f"6. List of tax payers: $nameSet")

  // 7. Refactor your method from question 3 to work for any inputted collection (HINT: look back at the collection family tree in the PowerPoint).
  def countAnySubmissions(name: String, data: Iterable[String]): Int = {
    data.count(_ == name)
  }

  // 8. Using your method from question 7, print the count of the same taxpayer in both the `Seq` from question 1 and the `Set` from question 5.
  println(f"8. Set: ${countAnySubmissions("Bruna", nameSet)}")
  println(f"8. Seq: ${countAnySubmissions("Bruna", nameSeq)}")


  // 9. Imagine that the user of this service needs to login however there are 6 users that have failed login attempts.
  // a. Write a Map[String, Int] to represent the number of failed attempts for each user.
  var failedAttemptsMap: ListMap[String, Int] = ListMap(
    "Bruna" -> 1,
    "April" -> 3,
    "Chad" -> 3,
    "Harry" -> 4,
    "Helen" -> 7,
    "Paul" -> 2,
  )

  println(f"9a. $failedAttemptsMap")

  // b. Print the number of failed attempts for the user at index position 0.
  println(f"9b. Failed attempts from the first user: ${failedAttemptsMap.head}")

  // OR another way of doing it is using toList!
   val firstUser: String = failedAttemptsMap.keys.toList(0)  //......or toSeq.head
   println(f"9b. Failed attempts from the first user: ${failedAttemptsMap(firstUser)}")

  // c. Add a new user to your Map who has 3 failed attempts.
  failedAttemptsMap = failedAttemptsMap + ("9c. Test person" -> 3)

  // OUTCOME: Failed attempts from the first user: (Bruna,1)
  // OUTCOME: Failed attempts from the first user: 1

  println(f"9c. $failedAttemptsMap")

  // d. Update the user at index position 1 to have a further failed attempt.
  val key = failedAttemptsMap.keys.toSeq(1)
  failedAttemptsMap = failedAttemptsMap + (key -> (failedAttemptsMap(key) + 1))

  println(f"9d. $failedAttemptsMap")

  // e. Remove the user at index position 5.
  failedAttemptsMap = failedAttemptsMap - failedAttemptsMap.keys.toSeq(5)

  println(f"9e. $failedAttemptsMap")

  // -------------------------------------------------------------------------------------------------------------------

  //  EXTENSION:
  // 1. Write two `Sets` that detail submissions on day 1 and day 2. (You can use your `Set` from question 5 if you want!)
  val set1: Set[String] = Set("Bruna", "James", "Tim")
  val set2: Set[String] = Set("Bruna", "James", "Steve")

  // Using built-in `Set` operations (research required here) and print lines, compare two submission days detailing:
  // a) Who submitted on both days
  println(f"Extension 1a. In both sets: ${set1.intersect(set2)}")

  // b) Who submitted only on the first day
  println(f"Extension 1b. Only set 1: ${set1 -- set2}")

  //c) A combined list of all unique submitters
  println(f"Extension 1c. Combined list: ${set1 ++ set2}")
}
