package com.test.weather.core.functional

import android.util.Log
import com.test.weather.UnitTest
import org.amshove.kluent.shouldBe
import org.amshove.kluent.shouldBeInstanceOf
import org.amshove.kluent.shouldEqualTo
import org.junit.Test

class EitherTest : UnitTest() {

    @Test
    fun `Either Right should return correct type`() {
        val result  = Either.Right(23.3)

        result shouldBeInstanceOf Either::class.java
        result.isRight shouldBe true
        result.isLeft shouldBe false
        result.either({},
                { right ->
                    right shouldBeInstanceOf Number::class.java
                    right shouldEqualTo 23.3
                })
    }

    @Test
    fun `Either Left should return correct type`() {
        val result = Either.Left(23.3)

        result shouldBeInstanceOf Either::class.java
        result.isLeft shouldBe true
        result.isRight shouldBe false
        result.either(
                { left ->
                    left shouldBeInstanceOf Number::class.java
                    left shouldEqualTo 23.3
                }, {})
    }

}