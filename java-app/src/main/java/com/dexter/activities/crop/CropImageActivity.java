package com.dexter.activities.crop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.dexter.utils.Constants;
import com.dexter.utils.R;
import com.yalantis.ucrop.UCrop;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import timber.log.Timber;

public class CropImageActivity extends AppCompatActivity {

    private static final String TAG = "CropImageActivity";
    private static final String IMG_PREFIX = "IMG_";
    private static final String IMG_SUFFIX = ".jpg";
    private float x;
    private float y;

    public static Intent getStartIntent(Context context, Uri data, float x, float y) {
        Intent intent = new Intent(context, CropImageActivity.class);
        intent.putExtra(Constants.uri, data);
        intent.putExtra(Constants.x, x);
        intent.putExtra(Constants.y, y);
        return intent;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Uri uri = intent.getParcelableExtra(Constants.uri);
        x = intent.getFloatExtra(Constants.x, -1);
        y = intent.getFloatExtra(Constants.y, -1);
        if (uri != null) {
            startCropActivity(uri);
        } else {
            finish();
        }
    }

    private void startCropActivity(@NonNull Uri uri) {
        @SuppressLint("SimpleDateFormat")
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String path = IMG_PREFIX + timeStamp + IMG_SUFFIX;
        UCrop uCrop = UCrop.of(uri, Uri.fromFile(new File(getCacheDir(), path)));
        uCrop = advancedConfig(uCrop);
        uCrop.start(CropImageActivity.this);
    }

    /**
     * Sometimes you want to adjust more options, it's done via {@link com.yalantis.ucrop.UCrop.Options} class.
     *
     * @param uCrop - ucrop builder instance
     * @return - ucrop builder instance
     */
    private UCrop advancedConfig(@NonNull UCrop uCrop) {
        UCrop.Options options = new UCrop.Options();
        options.withAspectRatio(x, y);
        return uCrop.withOptions(options);
    }

    private void handleCropResult(@NonNull Intent result) {
        final Uri resultUri = UCrop.getOutput(result);
        if (resultUri != null) {
            Intent intent = new Intent();
            intent.setData(resultUri);
            setResult(RESULT_OK, intent);
            finish();
        } else {
            Toast.makeText(CropImageActivity.this, R.string.toast_cannot_retrieve_cropped_image, Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressWarnings("ThrowableResultOfMethodCallIgnored")
    private void handleCropError(@NonNull Intent result) {
        final Throwable cropError = UCrop.getError(result);
        if (cropError != null) {
            Timber.d(TAG);
            Timber.e("handleCropError: " + cropError);
            Toast.makeText(CropImageActivity.this, cropError.getMessage(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(CropImageActivity.this, R.string.toast_unexpected_error, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == UCrop.REQUEST_CROP) {
                handleCropResult(data);
            }
        }
        if (resultCode == UCrop.RESULT_ERROR) {
            handleCropError(data);
        } else {
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
