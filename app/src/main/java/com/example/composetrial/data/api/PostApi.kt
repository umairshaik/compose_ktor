package com.example.composetrial.data.api

import com.example.composetrial.data.response.PostList
import io.ktor.client.*
import io.ktor.client.request.*

class PostApi(private val client: HttpClient) {
    suspend fun getPosts(): PostList =
        client.get("https://my-json-server.typicode.com/typicode/demo/posts")

}