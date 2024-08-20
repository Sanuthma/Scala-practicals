import scala.io.StdIn.readLine
@main def calculator : Unit ={
    val calculateInterest: Double => Double = deposit => {
        deposit match {
            case x if x <= 20000 => x * 0.02
            case x if x <= 200000 => x * 0.04
            case x if x <= 2000000 => x * 0.035
            case x if x > 2000000 => x * 0.065
        }
    }
    println("Enter the deposit amount: ")
    val depositAmount = readLine().toFloat

    val interest = calculateInterest(depositAmount)
    println(f"The interest earned on Rs. $depositAmount%.2f is Rs. $interest%.2f")
}