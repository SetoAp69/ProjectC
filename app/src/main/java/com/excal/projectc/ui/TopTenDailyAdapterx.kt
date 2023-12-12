package com.excal.projectc.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.excal.projectc.R
import com.excal.projectc.data.TopTenPhoneDailyItem

class TopTenDailyAdapterx (var context: Context, var list:List<TopTenPhoneDailyItem>): RecyclerView.Adapter<TopTenDailyAdapterx.ViewHolder>(){
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val name: TextView =view.findViewById(R.id.tv_name)
        val image: ImageView =view.findViewById(R.id.iv_image)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount():Int{
        return list.size
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int){
        holder.name.text=list[position].name
        Glide.with(context)
            .load(list[position].url)
            .into(holder.image)

    }

}