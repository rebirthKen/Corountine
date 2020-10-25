package com.example.chao_corountine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.chao_corountine.models.School
import com.example.chao_corountine.repository.SchoolRepository

class SchoolViewModel : ViewModel() {
    private val schoolId: MutableLiveData<String> = MutableLiveData()

    val school: LiveData<School> = Transformations.switchMap(schoolId) { schoolId ->
        SchoolRepository.getSchool(schoolId)
    } //observing liveData obj of schoolId

    fun setSchoolId(schoolId: String) {
        if (schoolId == this.schoolId.value) return
        this.schoolId.value = schoolId
    }

    fun cancelJobs() {
        SchoolRepository.cancelJobs()
    }
}