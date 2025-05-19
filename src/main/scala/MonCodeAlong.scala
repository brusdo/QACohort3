object MonCodeAlong extends App {

    // VAL = BEST PRACTICE
    val melons = 5 * 50
    val apples = 2 * 10
    val fizzyDrink = 6 * (100 * 1.20)

    //  val total = melons + apples + fizzyDrink

    //VAR - mutable (not best practice)
    var total: Double = 0
    total = total + apples
    println(total)
    total = total + melons
    println(total)
    total = total + fizzyDrink
    println(f"The current total is $total")
    println(total)
    println(melons)
    println(apples)
    println(fizzyDrink)
    println(total)

    //TYPES
    val wholeNumber: Int = 6483
    val littleNumber: Short = 68 // RARE - JUST USE INT
    val bigNumber: Long = 6237346482364847384L // MUST PUT L AT THE END TO BE A LONG NUMBER
    val littleDecimal: Float = 2.464748f // MUST PUT f (RARE)
    val decimal: Double = 45454.936 // USE THIS FOR DECIMALS!!!
    val text: String = "Hello world!"
    val trueFalse: Boolean = true //false
    val falseTrue: Boolean = false

    //println(trueFalse == falseTrue) //RUN IT???

    //OPERATORS

    val a: Int = 10
    val b: Int = 5
    val c: Int = 3

    val add: Int = a + b //SPECIFY TYPE!!! click commmand click on it you can find what something is!
    val subtract: Int = a - b
    val divide: Double = a / c
    val multiply: Int = a * b
    val modulus: Int = a % c // 10 % 3 remender when we want ODD and EVEN - EVEN WITHOUT REMENDER
    println(modulus)
    val even: Int = a % 2 //left with 0 = even
    println(even)

    //RELATIONAL OPERATORS
    val equality: Boolean = a == a // true/false
    val inequality: Boolean = a != b // NOT EQUAL TO
    val lessThan: Boolean = b < c
    val lessThanEqualTo: Boolean = b <= c
    val greaterThan: Boolean = b > c
    val greaterThanEqualsTo: Boolean = b >= c

    //LOGICAL OPERATORS
    val and = true && true // AND(&&) BOTH MUST TO BE TRUE TO RETURN TRUE
    val or = true || false // OR(||) ONE SIDE MUST TO BE TRUE
    val not = !false // NOT(!) TAKE A SINGLE BOOLEAN
    // you can add type by double clicking on...


    //FUNCTIONS AND METHODS
    //METHOD DEF (def or val) methods are functions but not all functions are a method
    // if you want to use a method you need to give a name, so you can call it
    // method we give parameters
    // def nameoOfMethod(parameter, but this can be empty): ReturnType = {
    // <expression 1>
    // <n number of expressions>
    // <last expression results in a value that is of the same type as the ReturnType>
    // DONT PRINT LINE INSIDE YOUR METHOD!!!
    // a method you can pass parameter

    def makeACupOfTea(sugar:Int, milk:Boolean): String = {
        s"You have made a cup of tea with $sugar spoons of sugar. Your milk selection is: $milk"
    }

    println(makeACupOfTea(7, milk = true)) // calling the method
    println(makeACupOfTea(1, milk = true)) // calling the method
    // you can interpolate with 'f' instead of '$'


    val vat: Double = 1.2
    //Write a method that calculates the final price of a product with VAT
    def FinalPrice(price: Double): Double = {
        price * vat
    }

    println(FinalPrice(100))  // Output: 120.0

    //FUNCTION VAL
    //LAZY VAL: SOMEWHERE IN BETWEEN


    //CLASSES: (think of these as a type)
    // multiple copies of something. This is where OOP really starts
    // Class starts with upperletter

    //THIS IS MY INSTRUCTION - Doesnt mean a lot by itself
    class Dog (val name:String, val age:Int, val LikesBananas:Boolean) {
        def speak:String = "woof" //declare in advance as it is the same for every dog/consistent (I can overright this later on if I want)
    }

    //Use the class to make objects (e.g. Dog)
    //Object of type Dog
    val loki:Dog = new Dog("Loki", 5, true) // if I want to access once I dont need "val loki:Dog"

    //How do I access? make a VAL inside your parameters!!!
    println(loki.speak)

}

