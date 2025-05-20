object TueCollectionsCodeAlong extends App {
//cant mix sets and strings
  val firstSet:Set[Int] = Set(1,2,3,4,5,5)
  println("First set: " + firstSet) //HashSet(not ordered and DON'T allow repeated values) by default when not specified
  val firstSeq: Seq[Int] = Seq(1,2,3,4,5,5)
  println("First seq: " + firstSeq) // or List(are ordered and allow repeated values) by default when not specified (Seq is sequence!)

  //Map takes 2 parameters (Key -> Value). We call there Key Value Pairs.
  //The Key must be unique (we cannot have 2 keys that are the same).
  val firstMap: Map[String, Int] = Map(
    "one" -> 1,
    "two" -> 2,
    "three" -> 3,
    "four" -> 4,
    "five" -> 5
  )
  println("First Map: " + firstMap)

//Accessing data
  //Seq access data:
  val getSeqHead: Int = firstSeq.head //index position 0 (first element)
  println("Seq Head: " + getSeqHead)

  val getSeqTail: Seq[Int] = firstSeq.tail //everything BUT the head
  println("Seq Tail: " + getSeqTail)

  val getSeqIndex: Int = firstSeq(3) //in the middle - ONLY works with ORDERED collections
  println("Seq Index: " + getSeqIndex)


  //SET
  val getSetIndex = firstSet(30) // same as "firstSet.contains(30)" check if the value is contained in the set
  println("Exist in Set" + getSetIndex)

  //We often filter for information
  val filterSet: Set[Int] = firstSet.filter(_ <3) // _ underscore to know it is not code
  println("Filter Set" + filterSet)

  val filterNotSet: Set[Int] = firstSet.filterNot(_ <3)
  println("FilterNot Set" + filterNotSet)

  val evenSet: Set[Int] = firstSet.filter(_ % 2 == 0)
  println("Even Set" + evenSet)


  //MAP (collection with capital "M")
  //It is easier to grab the value than the key - you must know your key
  val getMapValue: Int = firstMap("one") //Enter key to get the value
  println("Get Map Value: " + getMapValue)

  val getMapKey: String = firstMap.find(_._2 == 1).get._1 //find the value that is equal to 1 and get the key that matches it
  //underscore here is saying that I don't want to give a name
  //it is RISKY - Filter is better
  println("Get Map Key: " + getMapKey)

//  //Map Exercise:
//  //1. Make a set of names
//  val nameSet: Set[String] = Set("Bruna", "April", "Chad", "Andy")
//  println("Set of Names: " + nameSet)
//
//  //2. Create a map and filter for the colour "blue"
//  val colorMap: Map[Int, String] = Map(
//    1 -> "red",
//    2 -> "yellow",
//    3 -> "blue",
//    4 -> "green"
//  )
//  //val blue = colourMap.find(_._2 == "blue".)
//  val filterMap: Map[String, Int] = firstMap.filter(Num => Num._2==3)


  // 1. Make a set of names
  val nameSet: Set[String] = Set("Bruna", "April", "Chad", "Harry")
  println("Set of Names: " + nameSet)

  // 2. Create a map and filter for the colour "blue"
  val colorMap: Map[Int, String] = Map(
    1 -> "red",
    2 -> "yellow",
    3 -> "blue",
    4 -> "green"
  )
  val blueEntry = colorMap.filter(_._2 == "blue")
  println("Filtered Map for Blue: " + blueEntry)

  // 3. Filter a set of Ints to only contain Ints higher than 2
  val numberSet: Set[Int] = Set(1, 2, 3, 4, 5)
  val filteredNumbers = numberSet.filter(_ > 2)
  println("Filtered Numbers (>2): " + filteredNumbers)

  // 4. Add 1 to all numbers in a collection of Ints
  val addNumbers = numberSet.map(_ + 1)
  println("Numbers after adding 1: " + addNumbers)

  // 5. Return true if a Seq has a String that contains the letter "r"
  val nameSeq: Seq[String] = Seq("Bruna", "April", "Chad", "Harry")
  val hasR = nameSeq.exists(_.toLowerCase.contains("r"))
  println("Any name contains 'r'? " + hasR)

  // 6. Remove all even numbers from a Set of Ints
  val oddNumbers = numberSet.filter(_ % 2 != 0)
  println("Odd Numbers Only: " + oddNumbers)

//  val flatMapNames = names.flatMap(_.toUpperCase)
//  println("FlatMap: " + flatMapNames)

//map (map is a METHOD if lowercase 'm') - universal
// Use map to iterate (move through) a collection
// Do the same action for everyone in a group
def tripledSet(inputSet: Set[Int]): Set[Int] = inputSet.map {
  //   _ * 3 //not specific - same as below:
  number => number * 3
}
println("Tripled Set: " + tripledSet(firstSet))


//  def tripledSeq(inputSeq: Set[Int]): Seq[Int] = inputSeq.map {
//    //   _ * 3 //not specific - same as below:
//    number => number * 3
//  }
//  println("Tripled Seq: " + tripledSeq(firstSeq))

def tripledMap(inputMap: Map[String, Int]): Map[String, Int] = inputMap.map {
  case (key, value) => (key, value *3) // Can also change the key e.g. (key + "s", value *3)
}
println("Tripled Map: " + tripledMap(firstMap))


//Other ways to manipulate maps (so many!) e.g .exists (all that could be - get collection back),
// .contains(it is a check - you get a boolean back true or false)


val newSeq: Seq[Int] = Seq(6,7,8)
  // How to append things - Add to end
  val appendedListOne = firstSeq :+ newSeq
  println("Append :+ " + appendedListOne)
  //OR
  val appendedListTwo = firstSeq ++ newSeq // More used
  println("Append ++ " + appendedListTwo)

  //Prepend (put the list you want to add first)
  val prependSeqOne = newSeq ++ firstSeq // : + swap position
  println("Prepend ++ " + prependSeqOne)
  // or
  val prependSeqTwo = newSeq +: firstSeq // old school developers
  println("Prepend +: " + prependSeqTwo)
  // or
  val prependValue = 6 +: firstSeq
  println(prependValue)


}





