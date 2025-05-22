object WedHandlingMultipleOptions extends App {

  val weather: String = "winter"

  //IF/ELSE
  if (weather == "rainy") {
    println("Take a coat with a hood")
  } else if (weather == "sunny") { // you can have as many else/if as you need // if too long use a pattern match instead
    println("Wear sun cream")
  } else if (weather == "cold") {
    println("Wear a warm coat")
  } else {
    println("Not a valid option")
  }
    // TEST: For the above you need to make sure that every path needs to run (minimum 4 cases/test - other cases on else with characters, numbers, etc)

  //---------PATTERN MATCHING---------
  //Cleaner if/else statement
  weather match {
    case "rainy" => println("Take a coat with a hood")
    case "sunny" => println("Wear sun cream")
    case "cold" => println("Wear a warm coat")
    case _ => println("Not a valid option") //wild card "case of anything else"
  }

  //IF/ELSE with MULTIPLE options:
  val season: String = "winter"
  //How we approach this when we have multiple options:
  if (weather == "cold" || season == "winter") {
    println("Take a coat with a hood")
  } else {
    println("A light jacket is fine")
  }

  //---------PATTERN MATCHING---------
  //Pattern Matching gets confusing when I have lots of options (multiple conditionals)
  (weather, season) match {
    case (weather, season) if weather == "cold" || season == "winter" => println("Take a coat with a hood")
    //I can call it (x,y) for an example, but be consistent with the name
    case _ => println("Not a valid option")

  }

  // INT - slightly more careful
  val age: Int = 0

  if (age < 0) {
    println("Age cannot be negative")
  } else if (age >= 18) {
    println(s"You are an adult because you are $age")
  } else {
    println(s"You are a child because you are $age")
  }

  // match cases
  age match {
    case age if age < 0 => println("Age cannot be negative")
    case age if age < 18 => println(s"You are an adult because you are $age")
    case age if age >= 18 => println(s"You are a child because you are $age")
  }

  // EXERCISE:
// Shortcut:  cmd + f highlight, cmd+r replace
  //SCALA EXERCISE
  val givenAge: Int = 3
  givenAge match {
    case age if age >= 18 => println("Films ratings: U, PG, 12A, 15 or 18")
    case age if age >= 15 => println("Films ratings: U, PG, 12A or 15")
    case age if age >= 12 => println("Films ratings: U, PG or 12A")
    case age if age >= 8 => println("Films ratings: U or PG")
    case age if age >= 4 => println("Films ratings: U only")
    case age if age >= 0 => println(s"$age is too young to attend the cinema")
  }

  // ---------------------------------------------------

  //OPTIONS (getORElse) - give SOME or NONE information - You may see options as
  val name: Option[String] = Some("April")
  val emptyName: Option[String] = None
  println(name)
  println(emptyName)

  //.get is risky, getOrElse is safe
  //getOrElse is used when we want to return a default value if the None is returned
  //It will also take the 'Some' away, leaving us with just the internals
  def getName(name: Option[String]): String = name.getOrElse("This user has left the field empty")
  println(getName(name)) //Some("April")
  println(getName(emptyName)) //None

  // ---------------------------------------------------

  //TRY/CATCH - ERROR CATCHING
  //to protect ourselves - QA uses more than developers. GO TO in daily basis
  // example: Enter a number but the input is a string
  try {
    // All logic goes here! (If/else, pattern match, def, val
    val number = "one".toInt //I want to change the input to an Int from a String
    println(s"The number is $number")
  } catch {
    case error: NumberFormatException => println(s"$error This was not a valid input") // instead of "error" you will see "e"
  }

}