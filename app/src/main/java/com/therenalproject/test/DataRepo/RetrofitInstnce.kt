package com.therenalproject.test.DataRepo


import com.therenalproject.test.Apis.ApiCalls
import com.therenalproject.test.Utils.MyInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitInstnce {

    companion object {
        const val Base_Url = "https://dummyapi.io/data/api/"
        private val retrofit by lazy {

            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .connectTimeout(900, TimeUnit.MILLISECONDS)
                .addInterceptor(logging)
                .addInterceptor(MyInterceptor())
                .build()

            Retrofit.Builder()
                .baseUrl(Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()


        }
        val sericeApi by lazy {
            retrofit.create(ApiCalls::class.java)
        }
    }
}