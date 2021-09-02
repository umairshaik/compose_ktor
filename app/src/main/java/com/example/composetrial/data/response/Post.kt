package com.example.composetrial.data.response

data class PostList(val post: List<Post>)
data class Post(
    var id: Int? = null,
    var title: String? = null
)