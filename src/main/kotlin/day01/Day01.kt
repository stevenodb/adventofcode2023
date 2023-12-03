package day01

import readInput

val digitStrings: List<String> = listOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")

fun main() {
    val inputStrings = readInput("day01", "input")
    println("Day01/1: ${parseCalibrationValues(inputStrings)}")
    println("Day01/2: ${parseCalibrationValues(inputStrings, ::firstDigitStringMapper, ::lastDigitStringMapper)}")
}

fun firstDigitStringMapper(value: String): String {
    return digitStrings
        .mapIndexed { index, str -> index to value.indexOf(str) }
        .filter { it.second != -1 }
        .minByOrNull { it.second }
        ?.let { value.replaceFirst(digitStrings[it.first], (it.first + 1).toString()) }
        ?: value
}

fun lastDigitStringMapper(value: String): String {
    return digitStrings.reversed()
        .mapIndexed { index, str -> index to value.lastIndexOf(str) }
        .filter { it.second != -1 }
        .maxByOrNull { it.second }
        ?.let { value.replace(digitStrings[it.first], (it.first + 1).toString()) }
        ?: value
}

fun parseCalibrationValues(inputStrings: List<String>, firstValueMapper: (String) -> String = { it }, lastValueMapper: (String) -> String = { it }) =
    inputStrings
        .map(firstValueMapper)
        .map(lastValueMapper)
        .sumOf { str ->
            str.first { it.isDigit() }.digitToInt() * 10 +
                    str.last { it.isDigit() }.digitToInt()
        }