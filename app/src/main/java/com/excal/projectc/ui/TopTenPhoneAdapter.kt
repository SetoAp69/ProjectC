//package com.excal.projectc.ui
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
//import com.excal.projectc.R
//import com.excal.projectc.apidata.Phone
//import com.excal.projectc.databinding.PhoneListDataBinding
//class TopTenPhoneAdapter (var context: Context, var list: List<Phone>):RecyclerView.Adapter<TopTenPhoneAdapter.ViewHolder>(){
////    inner class PhoneViewHolder(val binding:PhoneListDataBinding):RecyclerView.ViewHolder(binding.root)
//    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
//        val name: TextView = view.findViewById(R.id.title)
//
//    }
//    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int):ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_menu, parent, false)
//        return ViewHolder(view)
//
//    }
//    override fun onBindViewHolder(holder: ViewHolder, position:Int){
//        holder.name.text=list[position].name
//
//
//    }
//
//    override fun getItemCount(): Int{
//        return list.size
//
//    }
//}


package com.excal.projectc.ui
import TopTenPhoneViewModel
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.excal.projectc.databinding.PhoneListDataBinding
class TopTenPhoneAdapter (private val viewModel:TopTenPhoneViewModel):RecyclerView.Adapter<TopTenPhoneAdapter.PhoneViewHolder>(){
    inner class PhoneViewHolder(val binding:PhoneListDataBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int): TopTenPhoneAdapter.PhoneViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PhoneListDataBinding.inflate(inflater, parent, false)
        return PhoneViewHolder(binding)

    }
    override fun onBindViewHolder(holder: TopTenPhoneAdapter.PhoneViewHolder, position:Int){
        holder.binding.phoneTitle.text=viewModel.phoneList.value!![position].name

    }

    override fun getItemCount(): Int{
        return viewModel.phoneList.value!!.size

    }
}