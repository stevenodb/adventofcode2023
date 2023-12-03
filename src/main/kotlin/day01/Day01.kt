package day01

import readInput

val digitStrings: List<String> = listOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")

fun main() {
    val inputStrings = readInput("day01", "input")
    println("Day01/1: ${parseCalibrationValues(inputStrings)}")
    println("Day01/2: ${parseCalibrationValues(inputStrings, ::digitStringMapper)}")
}

fun digitStringMapper(value: String): String {
    var newValue = value
    do {
        val firstHit = digitStrings
            .mapIndexed { index, str -> index to newValue.indexOf(str) }
            .filter { it.second != -1 }
            .minByOrNull { it.second }
            ?.let { newValue.replaceFirst(digitStrings[it.first], (it.first + 1).toString()) }
        firstHit?.let { newValue = firstHit }
    } while (firstHit != null)
    return newValue
}

fun parseCalibrationValues(inputStrings: List<String>, valueMapper: (String) -> String = { it }) =
    inputStrings
        .map(valueMapper)
        .sumOf { str ->
            str.first { it.isDigit() }.digitToInt() * 10 +
                    str.last { it.isDigit() }.digitToInt()
        }