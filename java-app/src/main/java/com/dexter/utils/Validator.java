package com.dexter.utils;

import android.content.Context;
import android.support.annotation.StringRes;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    /**
     * A method to validate an editText with a regex
     *
     * @param context          the context of the class to access class methods
     * @param editText         the editText which is to be validated
     * @param regex            the regular expression for which the validation is needed
     * @param errorStringResId the string to be shown when editText is not validated
     * @return true if is validate else false
     */
    public static boolean isValidate(Context context, EditText editText, String regex, @StringRes int errorStringResId) {
        String text = editText.getText().toString().trim();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (!matcher.matches()) {
            editText.requestFocus();
            editText.setError(context.getString(errorStringResId));
            return false;
        } else {
            editText.setError(null);
            return true;
        }
    }
}
