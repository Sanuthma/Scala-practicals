def countLetterOccurrences(words: List[String]): Int = {
  val lengths = words.map(_.length)
  
  lengths.reduce(_ + _)
}

@main def testCountLetterOccurrences(): Unit = {
  val words = List("apple", "banana", "cherry", "date")
  val totalCount = countLetterOccurrences(words)
  println(s"Total count of letter occurrences: $totalCount") 
}
