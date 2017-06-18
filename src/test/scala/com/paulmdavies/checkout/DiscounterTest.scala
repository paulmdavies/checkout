package com.paulmdavies.checkout

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class DiscounterTest extends FlatSpec with Matchers {
    val fooOffer = Offer("foo offer", "foo", 2)

    "Discounter" should "not change a basket if it has no offers" in {
        // Given
        val discounter = new Discounter(List.empty)
        val basket = List("foo", "foo", "foo", "foo", "foo")

        // When
        val basketWithDiscounts = discounter.applyDiscounts(basket)

        // Then
        basketWithDiscounts should equal(basket)
    }

    it should "not change an empty basket" in {
        // Given
        val discounter = new Discounter(List(fooOffer))
        val basket = List()

        // When
        val basketWithDiscounts = discounter.applyDiscounts(basket)

        // Then
        basketWithDiscounts should equal(List.empty)
    }

    it should "not change a basket containing only non-offer items" in {
        // Given
        val discounter = new Discounter(List(fooOffer))
        val basket = List("bar", "bar", "bar")

        // When
        val basketWithDiscounts = discounter.applyDiscounts(basket)

        // Then
        basketWithDiscounts should equal(basket)
    }

    it should "not apply any discounts to a basket containing insufficient items" in {
        // Given
        val discounter = new Discounter(List(fooOffer))
        val basket = List("foo")

        // When
        val basketWithDiscounts = discounter.applyDiscounts(basket)

        // Then
        basketWithDiscounts should be(List("foo"))
    }

    it should "apply an offer correctly multiple times" in {
        // Given
        val discounter = new Discounter(List(fooOffer))
        val basket = List("foo", "foo", "foo", "foo", "foo")

        // When
        val basketWithDiscounts = discounter.applyDiscounts(basket)

        // Then
        basketWithDiscounts should be(List("foo", "foo", "foo", "foo", "foo", "foo offer", "foo offer"))
    }

    it should "apply multiple offers in order" in {
        // Given
        val discounter = new Discounter(List(fooOffer, new Offer("bar offer", "bar", 1)))
        val basket = List("foo", "foo", "foo", "bar")

        // When
        val basketWithDiscounts = discounter.applyDiscounts(basket)

        // Then
        basketWithDiscounts should be(List("foo", "foo", "foo", "bar", "foo offer", "bar offer"))
    }

}
