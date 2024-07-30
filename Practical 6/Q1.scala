val inventory01: Map[Int, (String,Int,Double)] = Map(
    101 -> ("Potatos",40, 100.0),
    102 -> ("Beet", 30, 150.0),
    103 -> ("Onion", 20, 80)
)

val inventory02: Map[Int, (String,Int,Double)] = Map(
    103 -> ("Onion",50, 150.0),
    105 -> ("Carrot", 40, 300.0)
)

@main def main(): Unit={
    val productNames: List[String] = inventory01.values.map(_._1).toList
    println("Product Names in the inventory 01: ")
    productNames.foreach(println)

    val totalValue: Double = inventory01.values.map{
        case
        (_, quantity, price) => quantity*price
        }.sum
    println(s"Total value of all products in inventory01: ${totalValue}")

    val isEmpty: Boolean = inventory01.isEmpty
    println(s"Is inventory01 empty? ${isEmpty}")


    val mergedInventory: Map[Int, (String, Int, Double)] = inventory01 ++ inventory02.map {
        case (id,(name, quantity, price)) => id -> inventory01.get(id).map{
            case(_, oldQuantity, oldPrice) => (name, oldQuantity + quantity, oldPrice max price)
    }.getOrElse((name,quantity,price))
    }
    println("Merged Inventory: ")
    mergedInventory.foreach{ case (id, (name, quantity,price)) =>
    println(s"Product ID: $id, Name: $name, Quantity: $quantity, Price: $price")
    }

    val productID = 102
    println(s"Product with ID $productID:")
    inventory01.get(productID) match {
        
        case Some((name, quantity, price)) =>
            println(s"Name: $name, Quantity:$quantity, Price: $price")
        case None =>
            println("Does not exist in inventory01.")
    }
}