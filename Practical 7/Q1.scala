def filterEvenNumbers(numbers: List[Int]): List[Int] = {
  numbers.filter(number => number % 2 == 0)
}

@main def main: Unit = {
    val input = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val output = filterEvenNumbers(input)
    println(output) 
  }