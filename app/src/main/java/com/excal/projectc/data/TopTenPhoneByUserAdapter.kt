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

class TopTenPhoneByUserAdapter(var context: Context, var list:List<TopTenPhoneDailyItem>):RecyclerView.Adapter<TopTenPhoneByUserAdapter.ViewHolder>(){
    var listener : onItemClick?=null
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val name : TextView =view.findViewById(R.id.tv_title)
        val image : ImageView =view.findViewById(R.id.iv_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.phone_list_data,parent,false)
        return ViewHolder(view)

    }
    override fun onBindViewHolder(holder: ViewHolder, position:Int){
        holder.name.text=list[position].name
        Glide.with(holder.itemView.context)
            .load(list[position].url)
            .into(holder.image)
        holder.image.setOnClickListener {
            listener?.setOnItemClick(it,list[position])
        }

    }

    override fun getItemCount(): Int{
        return list.size

    }
    interface onItemClick{
        fun setOnItemClick(view : View, phone:TopTenPhoneDailyItem)
    }
}