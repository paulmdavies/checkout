package com.paulmdavies.checkout

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class DiscounterTest extends FlatSpec with Matchers {
    "Discounter" should "not change an empty basket" in {
        // Given
        val discounter = new Discounter
        val basket = List()

        // When
        val basketWithDiscounts = discounter.applyDiscounts(basket)

        // Then
        basketWithDiscounts should equal(List.empty)
    }

    it should "not apply any discounts to a basket containing fewer than two apples" in {
        // Given
        val discounter = new Discounter
        val basket = List("Apple")

        // When
        val basketWithDiscounts = discounter.applyDiscounts(basket)

        // Then
        basketWithDiscounts should be(List("Apple"))
    }

    it should "add a two-for-one on apples offer to a basket containing two apples" in {
        // Given
        val discounter = new Discounter
        val basket = List("Apple", "Apple")

        // When
        val basketWithDiscounts = discounter.applyDiscounts(basket)

        // Then
        basketWithDiscounts should be(List("Apple", "Apple", "Apples 2 for 1"))
    }

    it should "apply a two-for-one on apples offer correctly multiple times" in {
        // Given
        val discounter = new Discounter
        val basket = List("Apple", "Apple", "Apple", "Apple", "Apple")

        // When
        val basketWithDiscounts = discounter.applyDiscounts(basket)

        // Then
        basketWithDiscounts should be(List("Apple", "Apple", "Apple", "Apple", "Apple", "Apples 2 for 1", "Apples 2 for 1"))
    }
}
