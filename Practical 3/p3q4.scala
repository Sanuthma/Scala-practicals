import scala.io.StdIn.readLine
def sumOfEvens(numbers: List[Int]): Int = {
    numbers.filter(_ % 2 == 0).sum
  }

@main def evenSum ():Unit={
  println("Enter numbers seperated by spaces: ")
    val input = readLine
    val num = input.split(" ").toList.flatMap(_.trim.toIntOption)

    val sumEvens = sumOfEvens(num)
    println(s"Sum of even number is: $sumEvens")
  }
