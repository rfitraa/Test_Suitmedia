package com.fitra.testsuitmedia.data

import androidx.paging.PagingSource
import androidx.paging.PagingState

class UserPagingSource(private val apiService: ApiService): PagingSource<Int, DataItem>() {

    companion object{
        const val INITIAL_PAGE_INDEX = 1
    }

    override fun getRefreshKey(state: PagingState<Int, DataItem>): Int? {
        return 1
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataItem> {
        return try {
            val position = params.key ?: INITIAL_PAGE_INDEX

            val responseData = apiService.getAllUsers(position, 10)
            val userList = responseData.data
            val prevKey = if (position == INITIAL_PAGE_INDEX) null else position -1
            val nextKey = if (responseData.data.isEmpty()) null else position +1
            return LoadResult.Page(
                data = userList,
                prevKey = prevKey,
                nextKey = nextKey
            )
        }catch (e: Exception){
            return LoadResult.Error(e)
        }
    }
}