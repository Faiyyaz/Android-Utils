package com.dexter.utils

import android.content.Context
import android.os.Build
import android.support.annotation.StringRes
import android.text.Html
import android.widget.TextView

object TextUtils {

    /**
     * A function to check whether the string is empty
     *
     * @param text the string which needs to be checked
     * @return true when string is empty else false
     */
    fun isEmpty(text: String): Boolean {
        return android.text.TextUtils.isEmpty(text)
    }

    /**
     * A function to capitalise 1st letter of a string
     *
     * @param text the string for which the 1st letter need to be capitalized
     * @return the 1st letter capitalised string
     */
    fun caplitizeFirstWord(text: String): String {
        return text.capitalize()
    }

    /**
     * A function to convert int to string
     *
     * @param i the int which needs conversion
     * @return string value
     */
    fun intToString(i: Int): String {
        return i.toString()
    }

    /**
     * A function to get the string from its string resource id
     *
     * @param context     the context of the class to access class methods
     * @param stringResId the string resource id
     * @return the string defined for the stringResId
     */
    fun getStringFromResId(context: Context, @StringRes stringResId: Int): String {
        return context.getString(stringResId)
    }

    /**
     * A function to append or format a string to another string dynamically
     *
     * @param context     the context of the class to access class methods
     * @param stringResId the string resource id
     * @param text        the text need to be append to the string resource id
     * @return the formatted text
     */
    fun getFormattedString(context: Context, @StringRes stringResId: Int, text: String): String {
        return context.getString(stringResId, text)
    }

    /**
     * A function to append or format an int to string dynamically
     *
     * @param context     the context of the class to access class methods
     * @param stringResId the string resource id
     * @param i           the int need to be append to the string resource id
     * @return the formatted text
     */
    fun getFormattedString(context: Context, @StringRes stringResId: Int, i: Int): String {
        return context.getString(stringResId, i)
    }

    /**
     * A function to set Html text to a textView
     *
     * @param string the html string
     * @param textView the textView on which text needs to be set
     */
    fun setHtmlText(string: String, textView: TextView) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView.text = Html.fromHtml(string, Html.FROM_HTML_MODE_COMPACT).toString()
        } else {
            @Suppress("DEPRECATION")
            textView.text = Html.fromHtml(string).toString()
        }
    }
}
