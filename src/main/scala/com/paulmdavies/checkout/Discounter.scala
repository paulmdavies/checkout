package com.paulmdavies.checkout

class Discounter(offers : List[Offer]) {
    def applyDiscounts(items: List[String]) : List[String] = {
        val discounts = offers.flatMap(offer => {
            val numberOfOfferProduct = items.count(_ == offer.itemName)
            val numberOfOffers = numberOfOfferProduct / offer.requiredItemQuantity
            List.fill(numberOfOffers)(offer.name)
        })
        items ++ discounts
    }
}
