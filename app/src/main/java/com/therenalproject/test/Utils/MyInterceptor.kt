package com.therenalproject.test.Utils

import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newrequest=chain.request()
            .newBuilder()
            .header("app-id","60530ebbff46e67b63decda3")
            .build()

        return chain.proceed(newrequest)

    }
}