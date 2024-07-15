import scala.io.StdIn.readLine

def filterStrings(strings: List[String]): List[String] ={
    strings match
      case Nil => Nil
      case head :: tail =>
        if (head.length > 5) then head :: filterStrings(tail)
        else filterStrings(tail)
}
@main def filteredList():Unit ={
    println("Enter strings seperated by spaces: ")
    val input = readLine()
    val strings = input.split(" ").toList.map(_.trim)
    val flist = filterStrings(strings)
    println("Filtered strings:  ")
    flist.foreach(println)

}

