package com.dexter.utils

import java.text.DecimalFormat

object MathUtils {

    /**
     * A function to convert a double which contains more than 2 decimal places to a 2 decimal places
     *
     * @param d double value for which decimal places should be 2
     * @return the double value with 2 decimal places
     */
    fun roundDoubleDecimalToTwoDigit(d: Double): Double {
        val decimalFormat = DecimalFormat("#.##")
        return decimalFormat.format(d).toDouble()
    }

    /**
     * A function to convert a float which contains more than 2 decimal places to a 2 decimal places
     *
     * @param f float value for which decimal places should be 2
     * @return the float value with 2 decimal places
     */
    fun roundFloatDecimalToTwoDigit(f: Float): Float {
        val decimalFormat = DecimalFormat("#.##")
        return decimalFormat.format(f).toFloat()
    }

    /**
     * A function to convert a string which contains more than 2 decimal places to a 2 decimal places
     *
     * @param s string value for which decimal places should be 2
     * @return the string value with 2 decimal places
     */
    fun roundStringDecimalToTwoDigit(s: String): String {
        val decimalFormat = DecimalFormat("#.##")
        return decimalFormat.format(s)
    }
}
