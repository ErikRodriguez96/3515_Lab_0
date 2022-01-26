import java.util.Scanner
val reader = Scanner(System.`in`)

abstract class Shape (_name : String) {
    var name = _name
    open fun getArea(): Double {
        return 0.0;
    }
    open fun printDimensions() {
        println("No dimensions");
    }
}

fun main(args: Array<String>) {

    val square = makeSquare("My Square")
    println("Please enter dimensions for a Square ")
    println("Length: ")
    var sqLength = reader.nextInt()
    println("Height: ")
    var sqHeight = reader.nextInt()
    square.setDimensions(sqLength, sqHeight)

    val circle = makeCircle("My Circle")
    println("Please enter dimensions for a Circle ")
    println("Radius: ")
    var cirRadius = reader.nextInt()
    circle.setDimensions(cirRadius)

    val triangle = makeTriangle("My Triangle")
    println("Please enter dimensions for a Triangle ")
    println("Side1: ")
    var side1 = reader.nextInt()
    println("Side2: ")
    var side2 = reader.nextInt()
    println("Side3: ")
    var side3 = reader.nextInt()
    triangle.setDimensions(side1,side2,side3)

    val eqTriangle = makeEquiTriangle("My Eq. Triangle")
    println("Please enter dimensions for an Equilateral Triangle ")
    println("Side: ")
    var eqTriSide = reader.nextInt()
    eqTriangle.setDimensions(eqTriSide)

    println("-- Square --")
    println("Name = ${square.name}")
    square.printDimensions()
    println("Area = ${square.getArea()}\n")

    println("-- Circle --")
    println("Name = ${circle.name}")
    circle.printDimensions()
    println("Area = ${circle.getArea()}\n")

    println("-- Triangle --")
    println("Name = ${triangle.name}")
    triangle.printDimensions()
    println("Area = ${triangle.getArea()}\n")

    println("-- Equilateral Triangle --")
    println("Name = ${eqTriangle.name}")
    eqTriangle.printDimensions()
    println("Area = ${eqTriangle.getArea()}\n")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}

class makeSquare(_name: String) : Shape(_name){
    private var sqHeight = 0
    private var sqLength = 0

    fun setDimensions(length: Int, height: Int){
        sqLength = length
        sqHeight = height
    }

    override fun printDimensions() {
        println("Length = $sqLength, Height = $sqHeight")
    }

    override fun getArea(): Double {
        return (sqLength * sqHeight).toDouble()
    }
}

class makeCircle(_name: String) : Shape(_name){
    private var cirRadius = 0

    fun setDimensions(radius: Int){
        cirRadius = radius
    }

    override fun printDimensions() {
        println("Radius = $cirRadius, Diameter = ${cirRadius * 2}")
    }

    override fun getArea(): Double {
        return (Math.pow(cirRadius.toDouble(), 2.0) * Math.PI)
    }
}

open class makeTriangle(_name: String) : Shape(_name){
    private var side1 = 0
    private var side2 = 0
    private var side3 = 0

    fun setDimensions(triside1: Int, triside2: Int, triside3: Int){
        side1 = triside1
        side2 = triside2
        side3 = triside3
    }

    override fun printDimensions() {
        println("Side1 = $side1, Side2 = $side2, Side3 = $side3")
    }

    override fun getArea(): Double {
        var s = (side1 + side2 + side3) / 2
        return Math.sqrt((s * (s - side1) * (s - side2) * (s - side3)).toDouble())
    }
}

class makeEquiTriangle(_name: String) : makeTriangle(_name){
    private var side = 0

    fun setDimensions(triSide: Int){
        side = triSide
    }

    override fun printDimensions() {
        println("Side1 = $side, Side2 = $side, Side3 = $side")
    }

    override fun getArea(): Double {
        var s = (side * 3) / 2
        return Math.sqrt((s * ((s - side) * 3) ).toDouble())
    }
}