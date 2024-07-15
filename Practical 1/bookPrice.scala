def price(noOfCopies:Int):Double = {
    val coverPrice = 24.95
    val discount = 0.40
    val newPrice = coverPrice * (1 - discount)
    val totalPrice = newPrice * noOfCopies
    val shippingCost = 
        if(noOfCopies > 50){
            50 * 3.0 + (noOfCopies - 50) * 0.75
        }
        else{
            noOfCopies * 3.0
        }
    totalPrice + shippingCost
}

@main def bookPrice() = {
    val noOfCopies = 60
    println(s"The total price of $noOfCopies books is ${price(noOfCopies)}")
}