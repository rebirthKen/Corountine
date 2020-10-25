package com.example.chao_corountine.service

import com.example.chao_corountine.models.School
import retrofit2.http.GET
import retrofit2.http.Path

interface SchoolApiService {
    @GET(value = "holder/school/{schoolId}")
    suspend fun getSchool( @Path(value = "schoolId") schoolId: String ): School
}