package com.example.timerapp

import android.os.SystemClock
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class ChronometerViewModel : ViewModel() {

    private val ONE_SECOND: Long = 1000
    private var mElapsedTime = MutableLiveData<Long>()

    init {
        val initialTime = SystemClock.elapsedRealtime()
        Timer().scheduleAtFixedRate(object: TimerTask(){
            override fun run() {
                val newValue = (SystemClock.elapsedRealtime() - initialTime) / ONE_SECOND
                mElapsedTime.postValue(newValue)
            }
        }, ONE_SECOND, ONE_SECOND)
    }

    fun getElapsedTime() : LiveData<Long> {
        return mElapsedTime
    }

    override fun onCleared() {
        super.onCleared()
    }
}