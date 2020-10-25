package com.example.chao_corountine.repository

import androidx.lifecycle.LiveData
import com.example.chao_corountine.service.SchoolRetrofitBuilder
import com.example.chao_corountine.models.School
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main


var job: CompletableJob? = null //this is the key Coroutine can control over the async work that can start/cancel it

object SchoolRepository {
    fun getSchool(schoolId:String): LiveData<School> {
        job = Job()
        return object : LiveData<School>() {
            override fun onActive() {
                super.onActive()
                //inside onActive, we gonna use the job to make request to net-work on backend thread
                job?.also {
                    //what it does here is it creates an unique coroutine which was in the backend thread which ref to this
                    //this job
                    CoroutineScope(IO + it).launch {
                        val school = SchoolRetrofitBuilder.apiService.getSchool(schoolId = schoolId)

                        //since we cannot set the liveData on backend thread (except postValue)
                        //we need to switch to the main thread
                        withContext(Main) {
                            value = school
                            it.complete()
                        }


                    }
                }
            }
        }
    }

    //this gonna be called in the viewModel cancel func which would be triggered when activity got destroyed
    //so it somehow really looks like pass the lifeCycle to the repository
    fun cancelJobs() {
        job?.cancel()
    }
}