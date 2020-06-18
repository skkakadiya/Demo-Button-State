package com.test

import android.util.Patterns
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Sanjay on 18/6/20.
 */
class MainViewModel : ViewModel() {

    val emailAddress = MutableLiveData("")
    val valid = MediatorLiveData<Boolean>().apply {
        addSource(emailAddress) {
            value = isValid()
        }
    }
    private fun isValid(): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(emailAddress.value!!).matches()
    }

}