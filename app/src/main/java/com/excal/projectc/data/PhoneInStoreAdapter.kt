package com.excal.projectc.data
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.excal.projectc.R

class PhoneInStoreAdapter (var context: Context, var list:List<com.excal.projectc.data.TopTenPhoneDailyItem>):RecyclerView.Adapter<com.excal.projectc.data.PhoneInStoreAdapter.ViewHolder>(){
    var listener : onItemClick?=null
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val name : TextView =view.findViewById(R.id.tv_title)
        val image : ImageView =view.findViewById(R.id.iv_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int):PhoneInStoreAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.phone_list_data,parent,false)
        return ViewHolder(view)

    }
    override fun onBindViewHolder(holder: PhoneInStoreAdapter.ViewHolder, position:Int){
        val phone =list[position]
        holder.name.text=list[position].name
        Glide.with(context)
            .load(list[position].url)
            .into(holder.image)
        holder.image.setOnClickListener {
            listener?.setOnItemClick(it, list[position])
        }

    }

    override fun getItemCount(): Int{
        return list.size

    }
    interface onItemClick{
        fun setOnItemClick(view: View, phone:TopTenPhoneDailyItem)
    }
}