def volumeOfSphere(radius:Double): Double = {
    4/3 * math.Pi * radius * radius * radius
}

@main def volume() = {
    val radius = 5
    println{s"The volume of a sphere with radius $radius is ${volumeOfSphere(radius)}"}
}