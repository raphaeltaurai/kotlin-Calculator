//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val name = "World"
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println("Hello, " + name + "!")

    for (i in 1..5) {
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        println("i = $i")
    }
    val tip: Int = 6
    val top = tip.toFloat()

    println("$tip,\n $top")

    println("I have $tip, and $top")

    if (tip > top){
        println("I'm a lot of way")
    } else {
        println("You are off track")

    }

    val mylist = listOf("candy", "ish")
    println(mylist[0])

    myFunction("shawn", "taurai")

    val c1 = Car()

    c1.brand = "Ford"
    c1.model = "Mustang"
    c1.year = 1969

    println(c1.brand)

    val c2 = Car2("Mazda","Demio", 2014)

    c2.drive()
    c2.speed(300)
}

fun myFunction(fname: String, lname: String){
    println("$fname $lname")
}

class Car {
    var brand =""
    var model =""
    var year = 0
}

class Car2 (var brand: String, var model: String, var year: Int) {
    //Class Function
    fun drive() {
        println("Wrooom!")
    }

    fun speed(maxSpeed: Int) {
        println("Max speed is: $maxSpeed")
    }
}
