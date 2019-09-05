package com.codemobiles.myauthen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.codemobiles.myauthen.models.TestJSON
import com.codemobiles.myauthen.network.TestApiInterface
import kotlinx.android.synthetic.main.fragment_homework.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        //_view.recyclerView.layoutManager = GridLayoutManager(context, 2)

        feedData()

        return _view
    }

    private fun feedData() {
        TestApiInterface.getInstance().testJson().let { call ->

            Log.d("network", call.request().url().toString())

            call.enqueue(object : Callback<List<TestJSON>> {
                override fun onFailure(call: Call<List<TestJSON>>, t: Throwable) {
                    Log.e("cm_network", t.message.toString())
                }

                override fun onResponse(
                    call: Call<List<TestJSON>>,
                    response: Response<List<TestJSON>>
                ) {
                    Log.d("cm_network", response.body().toString())
                }
            })
        }
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
