object MonAfternoonTask extends App  {
  private def a: Boolean = (3 + 4) * 57 < 300
  private def b: Boolean = 144 / 12 >= 12
  private def c: Boolean = "Cat" < "Dog"
  private def d: Boolean = "Rabbit" < "Hamster"
  private def e: Boolean = 17 % 2 == 1
  private def f: Boolean = (75 / 9) < 30 && (89 / 6) < 20



  println(f"a: $a")
  println(f"b: $b")
  println(f"c: $c")
  println(f"d: $d")
  println(f"e: $e")
  println(f"f: $f")



  // 2. What is the difference between the `String` “I love scala already” and the print line “println (“I love scala already”)”?
  // one is a variable and the other is command that prints the value of that variable to stdout (the terminal)
    // Note: The three input/output (I/O) connections are called standard input (stdin), standard output (stdout) and standard error (stderr)
  System.err.println("This is an output to stderr`")
  System.out.println("This is an output to stdout`")

  // 3. Write a method to calculate the square of an `Int`. It should have an `Int` input parameter and `Int` return type
    // Note: You can't use Val for methods, but you can use for class
  private def square(input: Int): Int = {
    input * input
  }

  private val squareResult: Int = square(2)
  private val squareResult3: Int = square(3)
  println(f"square(2): $squareResult")
  println(f"square(3): $squareResult3")

//  4. Write a method to check if a number is odd. It should have an `Int` input parameter and `Boolean` return type.
  private def isOdd(input: Int): Boolean = {
    (input % 2) == 1
  }

  println(f"isOdd(4): ${isOdd(4)}")
  println(f"isOdd(5): ${isOdd(5)}")

  // 5. Consider a Library, there are many books. Write a Class called ‘Book’. What class parameters will your book need?
  // Can you include any class methods in the body? Can you consider type sensitivity in your class parameter(s) type(s)
  // (and what needs to be made here if you do…)?

  class Book (val name:String, val author:String, val available:Boolean = true) {
    private var _timesRead: Int = 0
    var language:String = "English"

    def timesRead: Int = _timesRead

    def readBook(): Unit = {
      _timesRead += 1
    }
  }

  private val book1:Book = new Book("Dracula", "Bram Stoker")
  println(f"is the Book ${book1.name} available: ${book1.available}. The language is ${book1.language}. It has been read ${book1.timesRead} times")
  book1.readBook()
  println(f"is the Book ${book1.name} available: ${book1.available}. The language is ${book1.language}. It has been read ${book1.timesRead} times")

  // 1. Convert a lowercase `String` to uppercase.
  private val e1: String = "bruna".toUpperCase
  println(e1)

  //  2. Convert the first letter of a `String` to uppercase.
  private val e2: String = "bruna".capitalize
  println(e2)

  //  3. “STRING” == “string”  Is this true or false? Why
  // ASCII values are different for upper and lowercase letters
  private val e3: Boolean = "STRING" == "string"
  println(e3)

  //  4. Can you simply convert the `String` “one” to the `Int` 1
  // No.

  //  5. Can you simply convert the `Int` 1 to `String` “one”?
  // No.

  //  6. Can you simply convert `Int` 1 to type `String`? Is the result as you would expect?
  // Yes.
  private val e6: String = 1.toString
  private val e7: Int = "35".toInt
  println(e6)
  println(e7)

  // Research 1:
  //  val new: String = "Bruna"
  // There are some protected keywords that cannot be used as a variable name (e.g. new, val, private)

  // REsearch 3
  // https://docs.scala-lang.org/tour/case-classes.html
  // Nice way to package up related data that cannot be changed (no setters, but getters for every parameter)
  case class OtherBook(code: String)
  val dracula = OtherBook("738837847")
  println(dracula.code)
}