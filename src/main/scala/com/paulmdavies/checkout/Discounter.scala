package com.paulmdavies.checkout

class Discounter {
    def applyDiscounts(items: List[String]) : List[String] = {
        val numberOfApples = items.count(item => item == "Apple")
        val numberOfAppleDiscounts = numberOfApples / 2
        return items ++ List.fill(numberOfAppleDiscounts)("Apples 2 for 1")
    }
}
