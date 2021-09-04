package com.example.composetrial.data.api

import android.util.Log
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.features.observer.*
import io.ktor.client.request.*
import io.ktor.http.*

private const val TIME_OUT = 60_000L

/**
 * Ktor is an asynchronous open source framework
 * https://ktor.io/
 * https://developer.android.com/kotlin/coroutines
 * https://kotlinlang.org/docs/reference/multiplatform.html
 * https://ktor.io/docs/http-client-engines.html
 * https://github.com/Kotlin/kotlinx.serialization
 * https://medium.com/google-developer-experts/how-to-use-ktor-client-on-android-dcdeddc066b9
 *
 * Using CIO engine rather than Android or OkHttp as there is sslhandshake bug in KTOR
 * https://github.com/ktorio/ktor/issues/1872
 *
 * CIO is a fully asynchronous coroutine-based engine that can be used for both JVM and Android platforms. It supports only HTTP/1.x for now.
 * */
fun ktorHttpClient() = HttpClient(CIO) {
    install(JsonFeature) {
        serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
        })
    }
    defaultRequest {
        parameter("api_key", "fc8a81aa13b0a1e4c2b401c2799757a8")
    }

    install(HttpTimeout) {
        connectTimeoutMillis = TIME_OUT
        socketTimeoutMillis = TIME_OUT
    }

    install(Logging) {
        logger = object : Logger {
            override fun log(message: String) {
                Log.v("Logger Ktor =>", message)
            }
        }
        level = LogLevel.ALL
    }

    install(ResponseObserver) {
        onResponse { response ->
            Log.d("HTTP status:", "${response.status.value}")
        }
    }

    install(DefaultRequest) {
        header(HttpHeaders.ContentType, ContentType.Application.Json)
    }
}