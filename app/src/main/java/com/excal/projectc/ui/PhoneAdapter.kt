package com.excal.projectc.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.excal.projectc.databinding.PhoneListDataBinding

class PhoneAdapter(private val viewModel: PhoneViewModel):RecyclerView.Adapter<PhoneAdapter.PhoneViewHolder>() {

    inner class PhoneViewHolder(val binding: PhoneListDataBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhoneViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PhoneListDataBinding.inflate(inflater, parent, false)
        return PhoneViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhoneViewHolder, position: Int) {
        holder.binding.phoneTitle.text=viewModel.phoneList.value!![position].title
    }

    override fun getItemCount(): Int {
        return viewModel.phoneList.value!!.size
    }
}