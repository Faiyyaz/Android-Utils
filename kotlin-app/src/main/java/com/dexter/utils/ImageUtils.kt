package com.dexter.utils

import android.support.annotation.DrawableRes
import android.widget.ImageView
import com.bumptech.glide.Glide

import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

object ImageUtils {

    /**
     * A function to load rectangular image using glide
     *
     * @param placeHolderImage is the drawable resource id of the image to be used as placeholder
     * @param errorImage is the drawable resource id of the image to be used as error image
     * @param imageView is the imageView on which the image needs to be set
     * @param imageUrl is the link of the image
     */
    fun loadImage(@DrawableRes placeHolderImage: Int, @DrawableRes errorImage: Int, imageView: ImageView, imageUrl: String) {
        val options = RequestOptions().placeholder(placeHolderImage).error(errorImage).diskCacheStrategy(DiskCacheStrategy.ALL)
        Glide.with(imageView)
                .load(imageUrl)
                .apply(options)
                .into(imageView)
    }

    /**
     * A function to load circular image using glide
     *
     * @param placeHolderImage is the drawable resource id of the image to be used as placeholder
     * @param errorImage is the drawable resource id of the image to be used as error image
     * @param imageView is the imageView on which the image needs to be set
     * @param imageUrl is the link of the image
     */
    fun loadCircularImage(@DrawableRes placeHolderImage: Int, @DrawableRes errorImage: Int, imageView: ImageView, imageUrl: String) {
        val options = RequestOptions().circleCrop().placeholder(placeHolderImage).error(errorImage).diskCacheStrategy(DiskCacheStrategy.ALL)
        Glide.with(imageView)
                .load(imageUrl)
                .apply(options)
                .into(imageView)
    }
}
