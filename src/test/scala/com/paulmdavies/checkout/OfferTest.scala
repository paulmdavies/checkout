package com.paulmdavies.checkout

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class OfferTest extends FlatSpec with Matchers {
    "Offer" should "fail if constructed with required item count of 0" in {
        an [Exception] should be thrownBy(Offer("foo", "bar", 0))
    }
}
