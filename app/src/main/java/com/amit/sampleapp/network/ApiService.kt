package com.amit.sampleapp.network

import com.amit.sampleapp.model.DataItemModel
import com.amit.sampleapp.utils.AppUtility
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET(AppUtility.API_ISSUES)
    fun getAllIssues(): Call<ArrayList<DataItemModel>>

    @GET(AppUtility.API_ISSUES+"/{userId}/comments")
    fun getAllComments(@Path("userId") otp: Int?): Call<ArrayList<DataItemModel>>
}