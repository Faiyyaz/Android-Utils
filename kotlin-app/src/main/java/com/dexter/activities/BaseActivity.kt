package com.dexter.activities

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.dexter.utils.Constants
import com.dexter.utils.TextUtils
import es.dmoral.toasty.Toasty
import timber.log.Timber

/**
 * Base Class which should be extended by all activities
 */
abstract class BaseActivity : AppCompatActivity() {

    /**
     * A function to get the layout file for the activity
     *
     * @return the layout resource id of the layout file to be used
     */
    @get:LayoutRes
    abstract val layout: Int

    /**
     * A function to get the timber tag
     *
     * @return returns the tag which will be used with Timber to log tags
     */
    abstract val tag: String

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)

        //adding tag to timber here
        Timber.tag(tag)

        onActivityCreated()
    }

    /**
     * Function which indicates that the activity onCreate has been called
     */
    abstract fun onActivityCreated()

    /**
     * A function to show toast message
     *
     * @param type type of toast
     * @param message message in toast
     */
    fun showToastMessage(type: String, @StringRes message: Int) {
        when (type) {
            Constants.success -> Toasty.success(this, TextUtils.getStringFromResId(this, message), Toast.LENGTH_LONG)
            Constants.error -> Toasty.error(this, TextUtils.getStringFromResId(this, message), Toast.LENGTH_LONG)
            Constants.info -> Toasty.info(this, TextUtils.getStringFromResId(this, message), Toast.LENGTH_LONG)
            Constants.warning -> Toasty.warning(this, TextUtils.getStringFromResId(this, message), Toast.LENGTH_LONG)
            Constants.normal -> Toasty.normal(this, TextUtils.getStringFromResId(this, message), Toast.LENGTH_LONG)
        }
    }
}