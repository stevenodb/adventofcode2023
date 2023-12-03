package day01

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day201KtTest : FunSpec({
    test("part 1 calibration fivethreeonezblqnsfk1") {
        parseCalibrationValues(listOf("fivethreeonezblqnsfk1")) shouldBe 11
    }
    test("part 1 calibration treb7uchet") {
        parseCalibrationValues(listOf("treb7uchet")) shouldBe 77
    }
    test("part 1 calibration 1abc2") {
        parseCalibrationValues(listOf("1abc2")) shouldBe 12
    }
    test("part 2 calibration fivethreeonezblqnsfk1") {
        parseCalibrationValues(listOf("fivethreeonezblqnsfk1"), ::firstDigitStringMapper) shouldBe 51
    }
    test("part 2 calibration two1nine") {
        parseCalibrationValues(listOf("two1nine"), ::firstDigitStringMapper) shouldBe 29
    }
    test("part 2 example input") {
        val values = """two1nine
            eightwothree
            abcone2threexyz
            xtwone3four
            4nineeightseven2
            zoneight234
            7pqrstsixteen
        """.trimIndent().lines()
        parseCalibrationValues(values, ::firstDigitStringMapper) shouldBe 281
    }
})