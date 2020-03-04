package org.example

import kotlin.test.Test
import kotlin.test.assertEquals

import io.kotest.core.spec.style.FunSpec
import io.kotest.core.test.TestCaseOrder
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

interface Sample {
    var value: Int
}

class SsnTest : FunSpec({

    testOrder = TestCaseOrder.Lexicographic

    beforeTest {
        println("Starting test ${it.name}!")
    }

    afterTest {
        println("Finished test ${it.a.name}!")
    }

    test("valid ssns") {
        val qwe = jsApply<Sample> {
            value = 1
        }
    }

    test("invalid ssn") {

    }
})
