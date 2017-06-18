package com.paulmdavies.checkout

class Checkout {
    def scanItems(basket: List[String]) : String = {
        val discounter = new Discounter(List(Offer("Apples 2 for 1", "Apple", 2)))
        val discountedBasket = discounter.applyDiscounts(basket)
        val total = discountedBasket.map {
            case "Orange" => 0.25
            case "Apple" => 0.60
            case "Apples 2 for 1" => -0.60
            case _ => throw new Exception("Unrecognised product")
        }.sum.toFloat
        "£%.2f".format(total)
    }
}
