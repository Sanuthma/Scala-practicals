def temp(celcsius:Double): Double = {
    celcsius * 1.8 * 32
}
@main def tempConvert()={
    val celcsius = 35
    println(s"The tempereature of $celcsius C is equal to ${temp(celcsius)} F")
}