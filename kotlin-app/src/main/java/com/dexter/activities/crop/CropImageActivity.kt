package com.dexter.activities.crop

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.dexter.utils.Constants
import com.dexter.utils.R
import com.yalantis.ucrop.UCrop
import timber.log.Timber
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class CropImageActivity : AppCompatActivity() {
    private var x: Float = 0.toFloat()
    private var y: Float = 0.toFloat()

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = intent
        val uri = intent.getParcelableExtra<Uri>(Constants.uri)
        x = intent.getFloatExtra(Constants.x, -1f)
        y = intent.getFloatExtra(Constants.y, -1f)
        if (uri != null) {
            startCropActivity(uri)
        } else {
            finish()
        }
    }

    private fun startCropActivity(uri: Uri) {
        @SuppressLint("SimpleDateFormat")
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val path = IMG_PREFIX + timeStamp + IMG_SUFFIX
        var uCrop = UCrop.of(uri, Uri.fromFile(File(cacheDir, path)))
        uCrop = advancedConfig(uCrop)
        uCrop.start(this@CropImageActivity)
    }

    /**
     * Sometimes you want to adjust more options, it's done via [UCrop.Options] class.
     *
     * @param uCrop - ucrop builder instance
     * @return - ucrop builder instance
     */
    private fun advancedConfig(uCrop: UCrop): UCrop {
        val options = UCrop.Options()
        options.withAspectRatio(x, y)
        return uCrop.withOptions(options)
    }

    private fun handleCropResult(result: Intent) {
        val resultUri = UCrop.getOutput(result)
        if (resultUri != null) {
            val intent = Intent()
            intent.data = resultUri
            setResult(Activity.RESULT_OK, intent)
            finish()
        } else {
            Toast.makeText(this@CropImageActivity, R.string.toast_cannot_retrieve_cropped_image, Toast.LENGTH_SHORT).show()
        }
    }

    private fun handleCropError(result: Intent) {
        val cropError = UCrop.getError(result)
        if (cropError != null) {
            Timber.d(TAG)
            Timber.e("handleCropError: $cropError")
            Toast.makeText(this@CropImageActivity, cropError.message, Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this@CropImageActivity, R.string.toast_unexpected_error, Toast.LENGTH_SHORT).show()
        }
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == UCrop.REQUEST_CROP) {
                handleCropResult(data!!)
            }
        }
        if (resultCode == UCrop.RESULT_ERROR) {
            handleCropError(data!!)
        } else {
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    companion object {

        private const val TAG = "CropImageActivity"
        private const val IMG_PREFIX = "IMG_"
        private const val IMG_SUFFIX = ".jpg"

        fun getStartIntent(context: Context, data: Uri, x: Float, y: Float): Intent {
            val intent = Intent(context, CropImageActivity::class.java)
            intent.putExtra(Constants.uri, data)
            intent.putExtra(Constants.x, x)
            intent.putExtra(Constants.y, y)
            return intent
        }
    }
}
