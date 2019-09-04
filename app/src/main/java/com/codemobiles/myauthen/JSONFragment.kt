package com.codemobiles.myauthen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_json.view.*

class JSONFragment : Fragment() {

    private lateinit var mAdapter: CustomAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val _view = inflater.inflate(R.layout.fragment_json, container, false)

        mAdapter = CustomAdapter(context!!)

        _view.recyclerView.adapter = mAdapter
        // important
        _view.recyclerView.layoutManager = LinearLayoutManager(context)

        //_view.recyclerView.layoutManager = LinearLayoutManager( context, RecyclerView.HORIZONTAL,false)

      //  _view.recyclerView.layoutManager = LinearLayoutManager( context, LinearLayoutManager.HORIZONTAL,false)

//          _view.recyclerView.layoutManager = GridLayoutManager(context, 2)


        return _view
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
