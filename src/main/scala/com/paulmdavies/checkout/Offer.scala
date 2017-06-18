package com.paulmdavies.checkout

case class Offer(name: String, itemName: String, requiredItemQuantity: Int) {
    if (requiredItemQuantity < 1) {
        throw new Exception("Required item quantity must be at least 1")
    }
}
