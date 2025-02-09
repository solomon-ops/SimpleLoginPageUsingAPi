package com.example.simpleloginpage

import retrofit2.Call
import retrofit2.http.GET

interface ApiBaseInterface {

    @GET("posts")
    fun getPostListApi(): Call<ArrayList<PostDetails>>



}