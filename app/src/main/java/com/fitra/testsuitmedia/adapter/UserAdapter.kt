package com.fitra.testsuitmedia.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fitra.testsuitmedia.data.DataItem
import com.fitra.testsuitmedia.databinding.UserListBinding

class UserAdapter: PagingDataAdapter<DataItem, UserAdapter.ViewHolder>(DIFF_CALLBACK) {

    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: DataItem)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ViewHolder(var binding: UserListBinding) : RecyclerView.ViewHolder(binding.root){
        fun binding(user: DataItem){
            binding.tvUsername.text = user.firstName + " " + user.lastName
            binding.tvEmail.text = user.email
            Glide.with(itemView)
                .load(user.avatar)
                .into(binding.cvPhoto)
        }

        fun clear() {
            binding.tvUsername.text = ""
            binding.tvEmail.text = ""
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = UserListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userList = getItem(position)
        holder.binding.apply {
            if (userList != null) {
                holder.binding(userList)
                holder.itemView.setOnClickListener {
                    onItemClickCallback.onItemClicked(
                        userList
                    )
                }
            }else{
                holder.clear()
            }
        }
    }

    companion object{
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DataItem>() {
            override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}