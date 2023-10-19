package com.excal.projectc.ui
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
        holder.binding.phoneTitle.text=viewModel.phoneList.value!![position].title

    }

    override fun getItemCount(): Int{
        return viewModel.phoneList.value!!.size

    }
}