package com.codemobiles.myauthen

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codemobiles.myauthen.models.Youtube
import com.codemobiles.myauthen.models.YoutubeResponse
import com.codemobiles.myauthen.network.ApiInterface
import kotlinx.android.synthetic.main.custom_list.view.*
import kotlinx.android.synthetic.main.fragment_homework.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class JSONFragment : Fragment() {

    private var mDataArray: ArrayList<Youtube>? = null
    private lateinit var mAdapter: CustomAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val _view = inflater.inflate(R.layout.fragment_json, container, false)

        mDataArray = ArrayList<Youtube>()

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

                    mDataArray?.let {

                        mDataArray!!.clear()

                        mDataArray!!.addAll(response.body()!!.youtubes)

                        //important
                        mAdapter.notifyDataSetChanged()
                    }


                }
            })
        }

    }


    inner class CustomAdapter(val context: Context) :
        RecyclerView.Adapter<CustomViewHolder>() {

        override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
            val item = mDataArray!![position]
            holder.title.text = item.title
            holder.subTitle.text = item.subtitle
        }

        override fun getItemCount(): Int = mDataArray!!.size

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
        val title: TextView = view.title_text_view
        val subTitle: TextView = view.subtitle_text_view
        val avatarImage: ImageView = view.avatar_image_view
        val youtubeImage: ImageView = view.youtube_image_view
    }
}
