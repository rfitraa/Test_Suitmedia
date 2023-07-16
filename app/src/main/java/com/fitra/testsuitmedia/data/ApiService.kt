package com.fitra.testsuitmedia.data

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("users")
    suspend fun getAllUsers(
        @Query("page") page : Int,
        @Query("per_page") per_page: Int
    ) : UserResponse
}