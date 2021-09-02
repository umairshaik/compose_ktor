package com.example.composetrial.repository

import com.example.composetrial.data.api.PostApi
import com.example.composetrial.data.response.PostList

class PostRepository(private val postApi: PostApi){
    suspend fun getPosts():PostList = postApi.getPosts()
}