package com.amit.sampleapp.repo

import com.amit.sampleapp.model.BaseModel
import com.amit.sampleapp.model.DataItemModel
import com.amit.sampleapp.network.ApiService
import com.amit.sampleapp.network.AppRetrofitClient
import retrofit2.Response

open class BaseRepository {

    var mApiService: ApiService

    init {
        mApiService = AppRetrofitClient.buildService(ApiService::class.java)
    }

    fun checkResponse(response: Response<ArrayList<DataItemModel>>): Boolean {
        var isValidResponse: Boolean = false
        if (response != null && response.isSuccessful) {
            isValidResponse = true
        }
        return isValidResponse
    }

    fun getError(response: BaseModel) {
//        response.errorMessage="something went wrong"
    }
}