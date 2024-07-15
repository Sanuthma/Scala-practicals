import scala.io.StdIn.readLine
@main def salary()={
    println("Enter the number of normal working hours: ")
    var NH = readLine().toInt
    println("Enter the number of OT hours: ")
    var OT = readLine().toInt
    var totalSalary = NH * 250 + OT * 85
    var takeHome= totalSalary * (1-0.12f)
    println(s"Take home salary : ${takeHome}")
}