package com.dexter.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dexter.utils.Constants;
import com.dexter.utils.TextUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import es.dmoral.toasty.Toasty;
import timber.log.Timber;

/**
 * Base Fragment Class which should be extended by all fragments
 */
public abstract class BaseFragment extends Fragment {

    private Unbinder mUnbinder;
    private Context mContext;

    @Override
    public final View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);

        //adding tag to timber here
        Timber.tag(getClassTag());

        //Binding ButterKnife
        mUnbinder = ButterKnife.bind(this, view);

        onViewCreated(view);
        return view;
    }

    /**
     * A method to get the layout file of the fragment
     *
     * @return the layout resource id of the layout file to be used
     */
    public abstract
    @LayoutRes
    int
    getLayout();

    /**
     * A Method which indicates that the fragment onCreateView has been called
     */
    public abstract void onViewCreated(View view);

    /**
     * A method to get the tag for timber
     *
     * @return returns the tag which will be used with Timber to log tags
     */
    public abstract String getClassTag();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    /**
     * A method to show toast message
     *
     * @param type type of toast
     * @param message message in toast
     */
    public void showToastMessage(String type, @StringRes int message) {
        switch (type) {
            case Constants.success:
                Toasty.success(mContext, TextUtils.getStringFromResId(mContext, message), Toast.LENGTH_LONG);
                break;
            case Constants.error:
                Toasty.error(mContext, TextUtils.getStringFromResId(mContext, message), Toast.LENGTH_LONG);
                break;
            case Constants.info:
                Toasty.info(mContext, TextUtils.getStringFromResId(mContext, message), Toast.LENGTH_LONG);
                break;
            case Constants.warning:
                Toasty.warning(mContext, TextUtils.getStringFromResId(mContext, message), Toast.LENGTH_LONG);
                break;
            case Constants.normal:
                Toasty.normal(mContext, TextUtils.getStringFromResId(mContext, message), Toast.LENGTH_LONG);
                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }
}
