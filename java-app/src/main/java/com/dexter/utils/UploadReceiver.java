package com.dexter.utils;

import android.content.Context;

import net.gotev.uploadservice.ServerResponse;
import net.gotev.uploadservice.UploadInfo;
import net.gotev.uploadservice.UploadServiceBroadcastReceiver;

/**
 * A class to track a specific upload
 */
public class UploadReceiver extends UploadServiceBroadcastReceiver {

    /**
     * A method which indicates the progress of the upload
     *
     * @param context    the context of the class
     * @param uploadInfo the information on the upload
     */
    @Override
    public void onProgress(Context context, UploadInfo uploadInfo) {
        super.onProgress(context, uploadInfo);
    }

    /**
     * A method which indicates that there is some error occurred while upload
     *
     * @param context        the context of the class
     * @param uploadInfo     the information on the upload
     * @param serverResponse the response returned by server
     * @param exception      the exception occurred
     */
    @Override
    public void onError(Context context, UploadInfo uploadInfo, ServerResponse serverResponse, Exception exception) {
        super.onError(context, uploadInfo, serverResponse, exception);
    }

    /**
     * A method which indicates that the upload is successful
     *
     * @param context        the context of the class
     * @param uploadInfo     the information on the upload
     * @param serverResponse the response returned by server
     */
    @Override
    public void onCompleted(Context context, UploadInfo uploadInfo, ServerResponse serverResponse) {
        super.onCompleted(context, uploadInfo, serverResponse);
    }

    /**
     * A method which indicates that upload is cancelled
     *
     * @param context    the context of the class
     * @param uploadInfo the information on the upload
     */
    @Override
    public void onCancelled(Context context, UploadInfo uploadInfo) {
        super.onCancelled(context, uploadInfo);
    }
}