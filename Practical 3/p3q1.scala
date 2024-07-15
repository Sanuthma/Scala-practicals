import scala.io.StdIn.readLine
def reverseString(s: String): String = {
    if (s.isEmpty) ""                  
    else reverseString(s.tail) + s.head 
  }

@main  def rev: Unit = {
    println("Enter a string");
    val input=readLine();
    val reversed = reverseString(input)
    println(s"Original string: $input")
    println(s"Reversed string: $reversed")
  }
