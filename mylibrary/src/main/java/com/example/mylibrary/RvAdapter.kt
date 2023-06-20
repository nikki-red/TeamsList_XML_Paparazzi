package com.example.mylibrary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.core.view.size
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mylibrary.databinding.SingleItemBinding


class RvAdapter(private var groupList: List<Group>) : RecyclerView.Adapter<RvAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: SingleItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(group: Group) {
            binding.group = group
            binding.executePendingBindings()

            binding.cardLayout.setOnClickListener {
                group.expand = !group.expand
                notifyItemChanged(adapterPosition)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //val binding = SingleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val layoutInflater = LayoutInflater.from(parent.context)
        val userbinding: SingleItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.single_item, parent, false)
        return ViewHolder(userbinding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val group = groupList[position]
        holder.bind(group)

        /*
        with(holder){
            with(groupList[position]){
                binding.groupName.text = this.name
                binding.groupDescription.text = this.description
                binding.expandedView.visibility = if (this.expand) View.VISIBLE else View.GONE
                binding.cardLayout.setOnClickListener {
                    this.expand = !this.expand
                    notifyItemChanged(adapterPosition)
                }
            }
        }

         */
    }
    override fun getItemCount(): Int {
        return groupList.size
    }
}