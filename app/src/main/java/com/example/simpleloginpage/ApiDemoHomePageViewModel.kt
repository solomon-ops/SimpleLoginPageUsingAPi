package com.example.simpleloginpage

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiDemoHomePageViewModel : ViewModel() {
    // TODO: Implement the ViewModel


    private lateinit var apiInterface: ApiBaseInterface


    //Live data
    val responseListLivedata: MutableLiveData<ArrayList<PostDetails>> by lazy {
        MutableLiveData<ArrayList<PostDetails>>()
    }

    //product list raw
    var PostList : ArrayList<PostDetails> = ArrayList()


    //API base object creation
    init {
        apiInterface = ApiBaseClient.getInstance().create(ApiBaseInterface::class.java)

    }


    //api call function -> returns product list
    fun getPostList() {

        apiInterface.getPostListApi().enqueue(object : Callback<ArrayList<PostDetails>> {

            override fun onResponse(
                call: Call<ArrayList<PostDetails>>, response: Response<ArrayList<PostDetails>>
            ) {
                apiInterface = ApiBaseClient.getInstance().create(ApiBaseInterface::class.java)
                if (response.isSuccessful && response.body() != null)
                {
                    /// success case
                    val list = response.body()
                    PostList = list!!

                    responseListLivedata.postValue(list)
                    Log.d("API RESPONSE", list.toString())
                }
            }

            override fun onFailure(call: Call<ArrayList<PostDetails>>, t: Throwable) {

                //failure case
                t.printStackTrace()
                Log.d("API RESPONSE", t.toString())

            }


        })
    }

}