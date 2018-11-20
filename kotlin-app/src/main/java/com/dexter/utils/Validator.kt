package com.dexter.utils

import android.content.Context
import android.support.annotation.StringRes
import android.widget.EditText
import java.util.regex.Pattern

object Validator {

    /**
     * A method to validate an editText with a regex
     *
     * @param context          the context of the class to access class methods
     * @param editText         the editText which is to be validated
     * @param regex            the regular expression for which the validation is needed
     * @param errorStringResId the string to be shown when editText is not validated
     * @return true if is validate else false
     */
    fun isValidate(context: Context, editText: EditText, regex: String, @StringRes errorStringResId: Int): Boolean {
        val text = editText.text.toString().trim()
        val pattern = Pattern.compile(regex)
        val matcher = pattern.matcher(text)
        return if (!matcher.matches()) {
            editText.requestFocus()
            editText.error = context.getString(errorStringResId)
            false
        } else {
            editText.error = null
            true
        }
    }
}
