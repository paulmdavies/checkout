package com.paulmdavies.checkout

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class CheckoutTest extends FlatSpec with Matchers {
    "Checkout" should "support an empty basket" in {
        // Given
        val checkout = new Checkout()
        val basket = List[String]()

        // When
        val cost = checkout.scanItems(basket)

        // Then
        cost should be("£0.00")
    }

    it should "correctly price oranges and apples" in {
        // Given
        val checkout = new Checkout()
        val basket = List("Apple", "Apple", "Orange")

        // When
        val cost = checkout.scanItems(basket)

        // Then
        cost should be("£1.45")
    }

    it should "throw an exception if a product other than orange or apple appears in basket" in {
        // Given
        val checkout = new Checkout()
        val basket = List("Potato")

        // When/Then
        an[Exception] should be thrownBy {
            checkout.scanItems(basket)
        }
    }
}