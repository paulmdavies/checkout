package com.paulmdavies.checkout

class Checkout {
    def scanItems(basket: List[String]) : String = {
        val total = basket.map {
            case "Orange" => 0.25
            case "Apple" => 0.60
            case _ => throw new Exception("Unrecognised product")
        }.sum.toFloat
        "£%.2f".format(total)
    }
}
