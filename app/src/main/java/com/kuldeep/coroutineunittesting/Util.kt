package com.kuldeep.coroutineunittesting

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Util(val dispatcher: CoroutineDispatcher) {

    suspend fun getUserName(): String {
        delay(10000)
        return "Kuldeep"
    }

    suspend fun getUser(): String{
        CoroutineScope(Dispatchers.Main).launch{
            delay(2000)
        }
        return "User - KULDEEP"
    }

    suspend fun getAddress(): String{
        withContext(dispatcher){
            delay(5000)
        }
        return "Address"
    }

    var globalArgs=false
    fun getAddressDetail(){
        CoroutineScope(dispatcher).launch {
            globalArgs=true
        }
    }
}