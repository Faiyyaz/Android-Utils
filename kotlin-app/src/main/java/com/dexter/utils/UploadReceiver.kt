package com.dexter.utils

import android.content.Context

import net.gotev.uploadservice.ServerResponse
import net.gotev.uploadservice.UploadInfo
import net.gotev.uploadservice.UploadServiceBroadcastReceiver

/**
 * A class to track a specific upload
 *
 *
 * use register() function to register the receiver
 * use unregister() function to unregister the receiver, if already registered
 */
class UploadReceiver : UploadServiceBroadcastReceiver() {

    /**
     * A function which indicates the progress of the upload
     *
     * @param context    the context of the class
     * @param uploadInfo the information on the upload
     */
    override fun onProgress(context: Context?, uploadInfo: UploadInfo?) {
        super.onProgress(context, uploadInfo)
    }

    /**
     * A function which indicates that there is some error occurred while upload
     *
     * @param context        the context of the class
     * @param uploadInfo     the information on the upload
     * @param serverResponse the response returned by server
     * @param exception      the exception occurred
     */
    override fun onError(context: Context?, uploadInfo: UploadInfo?, serverResponse: ServerResponse?, exception: Exception?) {
        super.onError(context, uploadInfo, serverResponse, exception)
    }

    /**
     * A function which indicates that the upload is successful
     *
     * @param context        the context of the class
     * @param uploadInfo     the information on the upload
     * @param serverResponse the response returned by server
     */
    override fun onCompleted(context: Context?, uploadInfo: UploadInfo?, serverResponse: ServerResponse?) {
        super.onCompleted(context, uploadInfo, serverResponse)
    }

    /**
     * A function which indicates that upload is cancelled
     *
     * @param context    the context of the class
     * @param uploadInfo the information on the upload
     */
    override fun onCancelled(context: Context?, uploadInfo: UploadInfo?) {
        super.onCancelled(context, uploadInfo)
    }
}