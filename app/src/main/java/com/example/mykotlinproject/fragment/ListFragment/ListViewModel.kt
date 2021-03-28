package com.example.mykotlinproject.fragment.ListFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mykotlinproject.network.ListMovie
import com.example.mykotlinproject.repo.MovieListSource
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListViewModel @Inject constructor(val moviewSource : MovieListSource): ViewModel(){

    var listMoviewdata = MutableLiveData<List<ListMovie>>()
    private var _eventNetworkError = MutableLiveData(false)


    fun getMoviewList(category : String, page : Int ){
        viewModelScope.launch {
            try {
                listMoviewdata.value = moviewSource.fetchMovieList(category, "26f381d6ab8dd659b22d983cab9aa255", "ru", page)
                _eventNetworkError.value = false
               // _isNetworkErrorShown.value = false

            } catch (e: Exception) {
//                if (playList.value.isNullOrEmpty()) {
//                    _eventNetworkError.value = true
//                }
            }
        }
    }

}