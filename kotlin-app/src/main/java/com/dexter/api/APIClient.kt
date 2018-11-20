package com.dexter.api

import android.content.Context
import com.dexter.utils.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Modifier
import java.util.concurrent.TimeUnit

object APIClient {

    private var retrofit: Retrofit? = null

    /**
     * @param context context of the class
     * @return retrofit instance
     */
    fun getClient(context: Context): Retrofit? {
        if (retrofit == null) {

            val httpClient = OkHttpClient.Builder()
            httpClient.connectTimeout(120, TimeUnit.SECONDS)
            httpClient.readTimeout(120, TimeUnit.SECONDS)

            val loggingInterceptor = HttpLoggingInterceptor()
            if (BuildConfig.DEBUG) {
                //print the logs in this case
                loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            } else {
                loggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
            }

            httpClient.addInterceptor(loggingInterceptor)

            val client = httpClient.build()

            val gson = GsonBuilder()
                    .excludeFieldsWithModifiers(Modifier.TRANSIENT)
                    .setLenient()
                    .create()

            retrofit = Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
        }
        return retrofit
    }
}
