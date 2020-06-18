package com.amit.sampleapp.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.amit.sampleapp.callback.ResponseListener
import com.amit.sampleapp.viewModel.BaseViewModel
import com.amit.sampleapp.model.DataItemModel
import com.amit.sampleapp.repo.GitHubRepo

class IssuesViewModel : BaseViewModel() {

    private var itemData: MutableLiveData<ArrayList<DataItemModel>>

    init {
        itemData = MutableLiveData<ArrayList<DataItemModel>>()
    }

    fun getItemData(): MutableLiveData<ArrayList<DataItemModel>> {
        return itemData
    }

    fun getAllIssues() {
        setProgress(true)
        isFailure.value = false
        GitHubRepo.getAllIssues(object : ResponseListener {
            override fun onSuccess(instance: Any) {
                setProgress(false)
                itemData.value = instance as ArrayList<DataItemModel>
            }

            override fun onFailure(t: Any) {
                isFailure.value = true
            }
        })
    }


}