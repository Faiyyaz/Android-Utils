package com.dexter.utils;

import android.content.Context;
import android.os.Build;
import android.support.annotation.StringRes;
import android.text.Html;
import android.widget.TextView;

public class TextUtils {

    /**
     * A method to check whether the string is empty
     *
     * @param text the string which needs to be checked
     * @return true when string is empty else false
     */
    public static boolean isEmpty(String text) {
        return android.text.TextUtils.isEmpty(text);
    }

    /**
     * A method to capitalise 1st letter of a string
     *
     * @param text the string for which the 1st letter need to be capitalized
     * @return the 1st letter capitalised string
     */
    public static String caplitizeFirstWord(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }

    /**
     * A method to convert int to string
     *
     * @param i the int which needs conversion
     * @return string value
     */
    public static String intToString(int i) {
        return String.valueOf(i);
    }

    /**
     * A method to get the string from its string resource id
     *
     * @param context     the context of the class to access class methods
     * @param stringResId the string resource id
     * @return the string defined for the stringResId
     */
    public static String getStringFromResId(Context context, @StringRes int stringResId) {
        return context.getString(stringResId);
    }

    /**
     * A method to append or format a string to another string dynamically
     *
     * @param context     the context of the class to access class methods
     * @param stringResId the string resource id
     * @param text        the text need to be append to the string resource id
     * @return the formatted text
     */
    public static String getFormattedString(Context context, @StringRes int stringResId, String text) {
        return context.getString(stringResId, text);
    }

    /**
     * A method to append or format an int to string dynamically
     *
     * @param context     the context of the class to access class methods
     * @param stringResId the string resource id
     * @param i           the int need to be append to the string resource id
     * @return the formatted text
     */
    public static String getFormattedString(Context context, @StringRes int stringResId, int i) {
        return context.getString(stringResId, i);
    }

    /**
     * A method to set Html text to a textView
     *
     * @param string   the html string
     * @param textView the textView on which text needs to be set
     */
    public static void setHtmlText(String string, TextView textView) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView.setText(Html.fromHtml(string, Html.FROM_HTML_MODE_COMPACT));
        } else {
            textView.setText(Html.fromHtml(string));
        }
    }
}
