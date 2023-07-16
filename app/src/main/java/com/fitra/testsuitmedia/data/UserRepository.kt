package com.fitra.testsuitmedia.data

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData

class UserRepository(private val apiService: ApiService) {
    companion object{
        @Volatile
        private var instance: UserRepository? = null
        fun getInstance(
            apiService: ApiService
        ): UserRepository =
            instance ?: synchronized(this){
                instance ?: UserRepository(apiService)
            }.also { instance = it }
    }

    fun getAllUser(): LiveData<PagingData<DataItem>>{
        return Pager(
            config = PagingConfig(
                pageSize = 10
            ),
            pagingSourceFactory = {
                UserPagingSource(apiService)
            }
        ).liveData
    }
}