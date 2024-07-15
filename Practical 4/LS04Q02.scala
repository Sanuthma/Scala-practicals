import scala.io.StdIn.readLine
def checkNum(num: Int): Unit = {
    num match
        case num if num <= 0 => println("A Negativ/Zero input")
        case num if num % 2 == 0 => println("An Even number input")
        case _ => println("An Odd number input")
}

@main def main(): Unit = {
    println("Enter an integer: ");
    val num = readLine().toInt;
    checkNum(num);
}