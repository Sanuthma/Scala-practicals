import scala.io.StdIn.readLine
@main def numberClassifier :Unit = {
    println("Enter an integer: ")
    val input = readLine().toInt
    
    val classifyNumber: Int => String = {
        case x if x <= 0 => "Negative/Zero is input"
        case x if x%2 == 0 => "Even number is given"
        case _ => "Odd number is given"
    }

    println(classifyNumber(input))
}