package com.amit.sampleapp.viewModel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel() : ViewModel() {

    var isProgressActive: ObservableField<Boolean>
    var isFailure: MutableLiveData<Boolean>

    //     var showProgress: MutableLiveData<Boolean>
    var showError: MutableLiveData<Boolean>

    init {
        isProgressActive = ObservableField()
        showError = MutableLiveData<Boolean>(false)
        isFailure = MutableLiveData<Boolean>(false)
    }

    fun setProgress(isActive: Boolean) {
        isProgressActive.set(isActive)
    }

    fun setFailure(failure: Boolean) {
        isFailure.value = failure
    }

    fun getFailureLiveData(): MutableLiveData<Boolean> {
        return isFailure
    }


//    fun checkResponse(response: BaseModel): Boolean {
//        var isValidResponse:Boolean=false
//        if (response.statusCode.equals("200", true)) {
//            isValidResponse=true
//        }
//        return isValidResponse
//    }
}