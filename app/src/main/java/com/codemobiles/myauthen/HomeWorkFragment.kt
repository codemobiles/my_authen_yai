package com.codemobiles.myauthen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_homework.view.*

class HomeWorkFragment : Fragment() {

    private lateinit var mAdapter: MyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val _view = inflater.inflate(R.layout.fragment_homework, container, false)


        mAdapter = MyAdapter()

        _view.recyclerView.adapter = mAdapter

        //important
        _view.recyclerView.layoutManager = GridLayoutManager(context,2)

        return _view
    }

    class MyAdapter() : RecyclerView.Adapter<MyViewHolder>() {

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): MyViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.custom_list, parent, false)

            return MyViewHolder(view)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        }

        override fun getItemCount() = 100
    }


    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}
