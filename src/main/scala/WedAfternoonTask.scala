object WedAfternoonTask extends App {

//  Task 1. John can reasonably carry 3 watermelons without a bag, and 5 with one bag.

//    a) Create a value to store a number of watermelons.
  val watermelons: Int = 1
  val bag: Boolean = false

//    b) Print appropriate messages based on the criteria above to tell John whether he:
  //    i. Doesn't need a bag
  //    ii. Needs a bag
  //  iii. Can't carry them
  //  Be sure to consider how you will handle invalid numbers.
  //  c) Use string interpolation to add to each message the number of watermelons John is trying to
  //    buy.
  //  d) Create a value to store a `Boolean` that indicates whether John has a bag with him or not.
  //  e) Use an if/else statement and this `Boolean` value to tell John whether he can or cannot by the
  //  desired number of watermelons in Task 1.
  if (watermelons <= 0) {
    println("You don't have watermelons")
  } else if(watermelons <= 3) {
    println(f"You have $watermelons watermelon(s). You can carry it and you don't need a bag")
  } else if (watermelons <= 5 && bag == true) {
    println(f"You have $watermelons watermelons AND you have a bag! You can carry it! :)")
  } else if (watermelons <= 5 && bag == false) {
    println(f"You have $watermelons watermelons, but you DON'T have a bag! Sorry, You CAN'T carry it!")
  } else {
    println(f"You have too many watermelons, you CAN'T carry them")
  }

//  2. A person is paid £0.45 per mile travelled. When they input their miles travelled it goes in as a
//  `String` (e.g. “twenty”). Given the distance inputted, calculate the amount to be paid back being
//    sure to use try/catch to account for errors.
  val inputMilesTravelled: String = "5"
  val ratePerMile: Double = 0.45

  try {
    val milesTravelled = inputMilesTravelled.toInt
    val totalToPay = milesTravelled * ratePerMile
    println(f"You travelled $milesTravelled miles! You will receive £$totalToPay")
  } catch {
    case _: NumberFormatException =>
      println(s"Invalid miles input: '$inputMilesTravelled' is not a valid. Please enter a valid number'")
  }

  //Potential improvements:
  //println(f"You travelled $milesTravelled miles! You will receive £$totalToPay%.2f")
  // %.2f in f"" to make sure it will show only 2 decimal places e.g. £2.50

// ------------------------------ 🤖 ------------------------------
//    EXTENSION:
//    Logical operators used in IF statements (e.g., && or <) have an order of precedence.

//  1. What is this order, where can we find it?
  // It helps to identify which operator to evaluate first (e.g. in maths we do multiplication first)
  // In logic we do:
  // FIRST: < > == !=
  // SECOND: &&
  // THIRD: ||

//    Let's try to apply it, try to predict the answer before coding it:
//    2. What would (true || false && false) result in?
    // FIRST: false && false = false
    // SECOND: true || false = TRUE
  println("Ext2: " + (true || false && false))

//    3. What about ((true || false) && false)? (Note the parentheses used here.)
    // Everything inside parentheses FIRST: (true || false) = true
    // then true && false = FALSE
  println("Ext3: " + ((true || false) && false))

//  4. And finally, how about (1 < 4 && 7 != 10 || 9 + 10 == 21)?
    // 1<4 true
    // 7 != 10 true
    // 9+10 = 19 == 21 false
    //-------------------------
    // (true && true || false)
    // true && true .... true
    // true || false ... TRUE
  println("Ext4: " + (1 < 4 && 7 != 10 || 9 + 10 == 21))

  // ------------------------------ 🤖 ------------------------------

//  RESEARCH:
//    If statements always return values. This means we can assign values based on if statements.
//    How would we go about doing this, or where could we search to find out?
    // ANSWER: Scala Intelli J, Scala documentation

//  Try out the example below:
//  1. Create two values that hold integers. Assign any integer you'd like to these values.
  val x: Int = 20
  val y: Int = 2
//  2. Create a new value of type `String` and assign it "yes" if the first value is greater than the second,
//  and "no" if the second value is greater. (Don’t overthink this!)
  val finalValue: String = "yes"
  if (x > y) {
    println( "yes")
  } else {
    println("no")
  }
}
