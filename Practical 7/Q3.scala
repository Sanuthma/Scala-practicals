def isPrime(number: Int): Boolean = {
    if (number <= 1) false
    else if (number == 2) true
    else {
      var isPrime = true
      for (i <- 2 to number / 2 if isPrime) {
        if (number % i == 0) isPrime = false
      }
      isPrime
    }    
}

def filterPrime(numbers: List[Int]): List[Int] = {
    numbers.filter(number => isPrime(number))
}

@main def main: Unit = {
    val input = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val output = filterPrime(input)
    println(output) 
}

