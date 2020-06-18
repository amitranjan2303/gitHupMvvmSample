package com.amit.sampleapp.callback

interface ResponseListener {
    fun onSuccess(instance: Any)
    fun onFailure(t: Any)
}