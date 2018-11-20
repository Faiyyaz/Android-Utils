package com.dexter.activities;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.dexter.utils.Constants;
import com.dexter.utils.TextUtils;

import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import timber.log.Timber;

/**
 * Base Class which should be extended by all activities
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());

        //Binding ButterKnife
        ButterKnife.bind(this);

        //adding tag to timber here
        Timber.tag(getTag());

        onActivityCreated();
    }

    /**
     * A method to get the layout file for the activity
     *
     * @return the layout resource id of the layout file to be used
     */
    public abstract
    @LayoutRes
    int getLayout();

    /**
     * A method to get the timber tag
     *
     * @return returns the tag which will be used with Timber to log tags
     */
    public abstract String getTag();

    /**
     * A method to indicate that the class onCreate() has been called
     *
     * Method which indicates that the activity onCreate has been called
     */
    public abstract void onActivityCreated();

    /**
     * A method to show toast message
     *
     * @param type type of toast
     * @param message message in toast
     */
    public void showToastMessage(String type, @StringRes int message) {
        switch (type) {
            case Constants.success:
                Toasty.success(this, TextUtils.getStringFromResId(this, message), Toast.LENGTH_LONG);
                break;
            case Constants.error:
                Toasty.error(this, TextUtils.getStringFromResId(this, message), Toast.LENGTH_LONG);
                break;
            case Constants.info:
                Toasty.info(this, TextUtils.getStringFromResId(this, message), Toast.LENGTH_LONG);
                break;
            case Constants.warning:
                Toasty.warning(this, TextUtils.getStringFromResId(this, message), Toast.LENGTH_LONG);
                break;
            case Constants.normal:
                Toasty.normal(this, TextUtils.getStringFromResId(this, message), Toast.LENGTH_LONG);
                break;
        }
    }
}