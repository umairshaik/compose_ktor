package com.example.composetrial

import androidx.lifecycle.ViewModel
import com.example.composetrial.repository.PostRepository

class MainActivityViewModel(private val postRepository: PostRepository): ViewModel()  {

    suspend fun getPosts() = postRepository.getPosts()
}