package com.dexter.fragments

import android.content.Context
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.dexter.utils.Constants
import com.dexter.utils.TextUtils
import es.dmoral.toasty.Toasty

import timber.log.Timber

/**
 * Base Fragment Class which should be extended by all fragments
 */
abstract class BaseFragment : Fragment() {

    private lateinit var mContext: Context

    /**
     * A function to get the layout file of the fragment
     *
     * @return the layout resource id of the layout file to be used
     */
    @get:LayoutRes
    abstract val layout: Int

    /**
     * A function to get the tag for timber
     *
     * @return returns the tag which will be used with Timber to log tags
     */
    abstract val classTag: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(layout, container, false)

        //adding tag to timber here
        Timber.tag(classTag)

        onViewCreated(view)
        return view
    }

    /**
     * A function which indicates that the fragment onCreateView has been called
     */
    abstract fun onViewCreated(view: View)

    /**
     * A method to show toast message
     *
     * @param type type of toast
     * @param message message in toast
     */
    fun showToastMessage(type: String, @StringRes message: Int) {
        when (type) {
            Constants.success -> Toasty.success(mContext, TextUtils.getStringFromResId(mContext, message), Toast.LENGTH_LONG)
            Constants.error -> Toasty.error(mContext, TextUtils.getStringFromResId(mContext, message), Toast.LENGTH_LONG)
            Constants.info -> Toasty.info(mContext, TextUtils.getStringFromResId(mContext, message), Toast.LENGTH_LONG)
            Constants.warning -> Toasty.warning(mContext, TextUtils.getStringFromResId(mContext, message), Toast.LENGTH_LONG)
            Constants.normal -> Toasty.normal(mContext, TextUtils.getStringFromResId(mContext, message), Toast.LENGTH_LONG)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mContext = context!!
    }
}
