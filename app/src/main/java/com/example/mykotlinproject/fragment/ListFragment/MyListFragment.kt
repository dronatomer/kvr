package com.example.mykotlinproject.fragment.ListFragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.dagger.module.viewModule.ViewModelFactory
import com.example.mykotlinproject.R
import com.example.mykotlinproject.adapter.RecyclerViewList
import com.example.mykotlinproject.di.App
import com.example.mykotlinproject.network.ListMovie
import com.example.mykotlinproject.network.MovieApi
import javax.inject.Inject

class MyListFragment : Fragment() {

    @Inject
    lateinit var listViewModelFactory: ViewModelFactory
    private lateinit var viewModel: ListViewModel
    lateinit var rvList : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_fragment, container, false)
        App.appComponent.inject(this)
        viewModel = ViewModelProvider(this, listViewModelFactory).get(ListViewModel::class.java)
        sendNewMovieList("top_rated")// required cat name
        setRecyclerView(view)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    fun sendNewMovieList(category: String) {
        viewModel.getMoviewList(category, 1)
       // attachPopularMoviesOnScrollListener()
    }

    fun setRecyclerView(view: View){
        rvList = view.findViewById(R.id.rv_list) as RecyclerView
        val linearlayout = LinearLayoutManager(context)
        rvList.layoutManager = linearlayout

      viewModel.listMoviewdata.observe(viewLifecycleOwner, Observer {
          sendData(it)
      })
    }

    fun sendData(list : List<ListMovie>){
        val movie = list
        val rv : RecyclerViewList = RecyclerViewList(context, movie)
        rvList.adapter = rv
    }
}