package com.amit.sampleapp.repo

import android.util.Log
import com.amit.sampleapp.callback.ResponseListener
import com.amit.sampleapp.model.DataItemModel
import com.vasitum.manager.NetWorkErrorManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

object GitHubRepo : BaseRepository() {

    fun getAllIssues(responseListener: ResponseListener?) {

        mApiService.getAllIssues().enqueue(object : Callback<ArrayList<DataItemModel>> {

            override fun onResponse(
                call: Call<ArrayList<DataItemModel>>,
                response: Response<ArrayList<DataItemModel>>
            ) {
                if (checkResponse(response)) {
                    responseListener?.onSuccess(response.body() as ArrayList<DataItemModel>)
                } else {
                    //Error Handling
                    Log.d("Exc","Exc")
                }
            }

            override fun onFailure(call: Call<ArrayList<DataItemModel>>, t: Throwable) {
                Log.d("Exc","Exc")
            }
        })

    }

    fun getAllComments(userId: Int?, responseListener: ResponseListener?) {
        mApiService.getAllComments(userId).enqueue(object : Callback<ArrayList<DataItemModel>> {


            override fun onResponse(
                call: Call<ArrayList<DataItemModel>>,
                response: Response<ArrayList<DataItemModel>>
            ) {
                if (checkResponse(response)) {
                    responseListener?.onSuccess(response.body() as ArrayList<DataItemModel>)
                } else {
                  //responseListener?.onFailure(Exception("Opps Something went wrong"))
                    NetWorkErrorManager(responseListener).showErrorDialog(-1,"Error","Opps Something went wrong")
                }
            }

            override fun onFailure(call: Call<ArrayList<DataItemModel>>, t: Throwable) {
                responseListener?.onFailure(Exception("Opps Something went wrong"))
            }
        })

    }
}