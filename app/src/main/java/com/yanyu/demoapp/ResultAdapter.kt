package com.yanyu.demoapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yanyu.demoapp.databinding.ItemResultBinding

class ResultAdapter constructor(private var list: ArrayList<ResultBean>) : RecyclerView.Adapter<ResultAdapter.ResultHolder>() {

    class ResultHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ResultHolder, position: Int) {
        val binding = ItemResultBinding.bind(holder.itemView)
        val resultBean = list[position]
        binding.tvUnit1000.text = resultBean.data1000
        binding.tvUnit1024.text = resultBean.data1024
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultHolder {
        return ResultHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_result, parent, false))
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(arrayList: java.util.ArrayList<ResultBean>) {
        list = arrayList
        notifyDataSetChanged()
    }
}