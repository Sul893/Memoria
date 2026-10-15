package com.example.memoria.presentation.main

import androidx.lifecycle.ViewModel
import com.example.memoria.domain.MemoEntity
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch


// необходимо добавить валидацию данных
class MainViewModel: ViewModel() {

    private val TAG = "mainViewModel"
    private val memoList = ArrayList<MemoEntity>()

    private var memo = MemoEntity(0,"","",)
    var memo_id = 0

    val lastMemoAddedLiveData = MutableLiveData<MemoEntity>()

    fun onSubmit(name: String, description: String){

        memo = MemoEntity(memo_id++, name, description)

        memoList.add(memo)
        lastMemoAddedLiveData.value = memo

        Log.i(TAG, lastMemoAddedLiveData.value.toString())

        Log.i(TAG, "Name: " + name + ", Description: " + description)
    }
}