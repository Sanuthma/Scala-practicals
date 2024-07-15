def runningTime():Int = {
    val easyPaceTime = 8
    val tempoPaceTime = 7
    val easyPaceDistance = 2+2
    val tempoPaceDistance = 3

    (easyPaceDistance * easyPaceTime) + (tempoPaceDistance * tempoPaceTime)
}
@main def totalTime() = {
    println{s"The total running time to rach your home is ${runningTime()}"}
}