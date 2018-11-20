package com.dexter.utils;

import java.text.DecimalFormat;

public class MathUtils {

    /**
     * A method to convert a double which contains more than 2 decimal places to a 2 decimal places
     *
     * @param d double value for which decimal places should be 2
     * @return the double value with 2 decimal places
     */
    public static Double roundDoubleDecimalToTwoDigit(double d) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return Double.valueOf(decimalFormat.format(d));
    }

    /**
     * A method to convert a float which contains more than 2 decimal places to a 2 decimal places
     *
     * @param f float value for which decimal places should be 2
     * @return the float value with 2 decimal places
     */
    public static float roundFloatDecimalToTwoDigit(float f) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return Float.parseFloat(decimalFormat.format(f));
    }

    /**
     * A method to convert a string which contains more than 2 decimal places to a 2 decimal places
     *
     * @param s string value for which decimal places should be 2
     * @return the string value with 2 decimal places
     */
    public static String roundStringDecimalToTwoDigit(String s) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return decimalFormat.format(s);
    }
}
