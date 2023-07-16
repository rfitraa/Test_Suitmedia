package com.fitra.testsuitmedia.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.fitra.testsuitmedia.data.DataItem
import com.fitra.testsuitmedia.data.UserRepository

class ThirdScreenViewModel(private val userRepository: UserRepository): ViewModel() {
    val getAllUser: LiveData<PagingData<DataItem>> = userRepository.getAllUser().cachedIn(viewModelScope)
}