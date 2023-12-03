package day01

import readInput

fun main() {
    val sum = readInput("day01", "input")
        .map {
            it.first { c -> c.isDigit() }.digitToInt() * 10
            +it.last { c -> c.isDigit() }.digitToInt()
        }.sum()
    print("Day01: $sum")
}