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

    it should "correctly price oranges" in {
        // Given
        val checkout = new Checkout()
        val basket = List("Orange")

        // When
        val cost = checkout.scanItems(basket)

        // Then
        cost should be("£0.25")
    }

    it should "correctly price apples" in {
        // Given
        val checkout = new Checkout()
        val basket = List("Apple")

        // When
        val cost = checkout.scanItems(basket)

        // Then
        cost should be("£0.60")
    }

    it should "apply a two-for-one offer on apples" in {
        // Given
        val checkout = new Checkout()
        val basket = List("Apple", "Apple")

        // When
        val cost = checkout.scanItems(basket)

        // Then
        cost should be("£0.60")
    }

    it should "apply a three-for-two offer on oranges" in {
        // Given
        val checkout = new Checkout()
        val basket = List("Orange", "Orange", "Orange")

        // When
        val cost = checkout.scanItems(basket)

        // Then
        cost should be("£0.50")
    }

    it should "correctly price a basket of oranges and apples" in {
        // Given
        val checkout = new Checkout()
        val basket = List.fill(11)("Apple") ++ List.fill(10)("Orange")

        // When
        val cost = checkout.scanItems(basket)

        // Then
        cost should be("£5.35")
    }

    it should "throw an exception if an unknown product appears in basket" in {
        // Given
        val checkout = new Checkout()
        val basket = List("Potato")

        // When/Then
        an[Exception] should be thrownBy {
            checkout.scanItems(basket)
        }
    }
}