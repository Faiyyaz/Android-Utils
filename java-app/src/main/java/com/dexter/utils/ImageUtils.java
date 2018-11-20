package com.dexter.utils;

import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

public class ImageUtils {

    /**
     * A method to load rectangular image using glide
     *
     * @param placeHolderImage is the drawable resource id of the image to be used as placeholder
     * @param errorImage is the drawable resource id of the image to be used as error image
     * @param imageView is the imageView on which the image needs to be set
     * @param imageUrl is the link of the image
     */
    public static void loadImage(@DrawableRes int placeHolderImage, @DrawableRes int errorImage, ImageView imageView, String imageUrl) {
        RequestOptions options = new RequestOptions().placeholder(placeHolderImage).error(errorImage).diskCacheStrategy(DiskCacheStrategy.ALL);
        GlideApp.with(imageView)
                .load(imageUrl)
                .apply(options)
                .into(imageView);
    }

    /**
     * A method to load circular image using glide
     *
     * @param placeHolderImage is the drawable resource id of the image to be used as placeholder
     * @param errorImage is the drawable resource id of the image to be used as error image
     * @param imageView is the imageView on which the image needs to be set
     * @param imageUrl is the link of the image
     */
    public static void loadCircularImage(@DrawableRes int placeHolderImage, @DrawableRes int errorImage, ImageView imageView, String imageUrl) {
        RequestOptions options = new RequestOptions().circleCrop().placeholder(placeHolderImage).error(errorImage).diskCacheStrategy(DiskCacheStrategy.ALL);
        GlideApp.with(imageView)
                .load(imageUrl)
                .apply(options)
                .into(imageView);
    }
}
