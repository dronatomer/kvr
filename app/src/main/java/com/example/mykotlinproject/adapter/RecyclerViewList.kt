package com.example.mykotlinproject.adapter

import android.content.Context
import android.view.Gravity.apply
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.GravityCompat.apply
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mykotlinproject.R
import com.example.mykotlinproject.network.ListMovie
import java.security.PrivateKey

internal class RecyclerViewList(val mActivity: Context?, private var listmovie: List<ListMovie>) : RecyclerView.Adapter<RecyclerViewList.MyViewHolder>() {

    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val iv_image: ImageView = view.findViewById(R.id.iv_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewList.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.movie_list, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
      return  listmovie.size

    }

    override fun onBindViewHolder(holder: RecyclerViewList.MyViewHolder, position: Int) {
        Glide.with(mActivity!!)
                .load(listmovie.get(position).poster_path)
                .fitCenter()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .fallback(R.drawable.ic_launcher_background)
                .into(holder.iv_image)


    }


}


