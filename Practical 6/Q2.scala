import scala.io.StdIn._

def printStudentRecord(name: String, marks: Int, totalMarks: Int): Unit = {
  val percentage = calculatePercentage(marks, totalMarks)
  val grade = calculateGrade(percentage)

  println(s"Name: $name")
  println(s"Marks: $marks")
  println(s"Total Marks: $totalMarks")
  println(f"Percentage: $percentage%.2f%%")
  println(s"Grade: $grade")
}

def getStudentInfo(): (String, Int, Int) = {
  def readInput(prompt: String): String = {
    print(prompt)
    readLine()
  }

  def validateAndRead(prompt: String, validator: String => Boolean): String = {
    var input = readInput(prompt)
    while (!validator(input)) {
      println("Invalid input. Please try again.")
      input = readInput(prompt)
    }
    input
  }

  val name = validateAndRead("Enter student name: ", _.nonEmpty)
  val marks = validateAndRead("Enter marks: ", _.matches("\\d+")).toInt
  val totalMarks = validateAndRead("Enter total possible marks: ", _.matches("\\d+")).toInt

  (name, marks, totalMarks)
}

def validateInput(name: String, marks: Int, totalMarks: Int): Boolean = {
  name.nonEmpty && marks >= 0 && marks <= totalMarks
}

def calculatePercentage(marks: Int, totalMarks: Int): Double = {
  marks.toDouble / totalMarks * 100
}

def calculateGrade(percentage: Double): Char = {
  percentage match {
    case p if p >= 90 => 'A'
    case p if p >= 75 => 'B'
    case p if p >= 50 => 'C'
    case _ => 'D'
  }
}

def getStudentInfoWithRetry(): (String, Int, Int) = {
  var student: Option[(String, Int, Int)] = None
  while (student.isEmpty) {
    val newStudent = getStudentInfo()
    val (name, marks, totalMarks) = newStudent
    if (validateInput(name, marks, totalMarks)) {
      student = Some(newStudent)
    } else {
      println("Invalid input. Please try again.")
    }
  }
  student.get
}

@main def main(): Unit = {
  val (name, marks, totalMarks) = getStudentInfoWithRetry()
  printStudentRecord(name, marks, totalMarks)
}
