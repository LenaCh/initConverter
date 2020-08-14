package converter

import java.util.*

enum class Measure(val short: String, val singular: String, val plural: String, val unitForHub: Double) {
    METER("m", "meter", "meters", 1.0),
    KILOMETER("km", "kilometer", "kilometers", 1_000.0),
    CENTIMETER("cm", "centimeter", "centimeters", 0.01),
    MILLIMETER("mm", "millimeter", "millimeters", 0.001),
    MILE("mi", "mile", "miles", 1_609.35),
    YARD("yd", "yard", "yards", 0.9144),
    FOOT("ft", "foot", "feet", 0.3048),
    INCH("in", "inch", "inches", 0.0254),
    GRAMM("g", "gram", "grams", 1.0),
    KILOGRAMM("kg", "kilogram", "kilograms", 1_000.0),
    MILLIGRAM("mg", "milligram", "milligrams", 0.001),
    POUNDS("lb", "pound", "pounds", 453.592),
    OUNECE("oz", "ounce", "ounces", 28.3495);

    companion object {
        fun findMeashure(measure: String): String {
            for (enum in Measure.values()) {
                if (measure == enum.short || measure == enum.plural || measure == enum.singular) return enum.toString()
            }
            return " "
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    do {
        val input = scanner.nextLine()
        if (input == " " || input.isEmpty() || input.toLowerCase().equals("exit")) {
            if (input.equals("Exit")) break else println("Enter what you want to convert (or exit): ")
        } else {
            val number = input.split(" ")[0].toDouble()
            val measure = Measure.findMeashure(input.split(" ")[1].toLowerCase())
            val toMeashur = Measure.findMeashure(input.split(" ")[3].toLowerCase())
            val res = (Measure.valueOf(measure).unitForHub * number) / (Measure.valueOf(toMeashur).unitForHub)
            var resultToMeashure = " "
            var resultMeasure = " "
            when {
                res == 1.0 -> resultToMeashure = Measure.valueOf(toMeashur).singular
                res > 1.0 -> resultToMeashure = Measure.valueOf(toMeashur).plural
            }
            when {
                number == 1.0 -> resultMeasure = Measure.valueOf(measure).singular
                number > 1.0 -> resultMeasure = Measure.valueOf(measure).plural
            }
            println("Enter what you want to convert (or exit): $number $resultMeasure is $res $resultToMeashure")
        }
    } while (!input.equals("exit"))
}