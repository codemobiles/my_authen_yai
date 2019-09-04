package com.codemobiles.myauthen

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codemobiles.myauthen.models.YoutubeResponse
import com.codemobiles.myauthen.network.ApiInterface
import kotlinx.android.synthetic.main.fragment_homework.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class JSONFragment : Fragment() {

    private lateinit var mAdapter: CustomAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val _view = inflater.inflate(R.layout.fragment_json, container, false)

        mAdapter = CustomAdapter(context!!)

        _view.recyclerView.let {
            it.adapter = mAdapter
            it.layoutManager = LinearLayoutManager(context)
        }

        feedData()

        return _view
    }

    private fun feedData() {
        ApiInterface.getInstance().getYoutube("admin", "password", "foods").let { call ->

            Log.d("network", call.request().url().toString())

            call.enqueue(object : Callback<YoutubeResponse> {
                override fun onFailure(call: Call<YoutubeResponse>, t: Throwable) {
                    Log.d("network", t.message.toString())
                }

                override fun onResponse(
                    call: Call<YoutubeResponse>,
                    response: Response<YoutubeResponse>
                ) {
                    Log.d("network", response.body().toString())
                }
            })
        }

    }


    class CustomAdapter(val context: Context) :
        RecyclerView.Adapter<CustomViewHolder>() {

        override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        }

        override fun getItemCount(): Int = 100

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
            return CustomViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.custom_list,
                    parent,
                    false
                )
            )
        }
    }

    class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}
