package com.example.mvvmdemo.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmdemo.databinding.ApiListBinding
import com.example.mvvmdemo.model.users.UsersResponseItem

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private var responseList = mutableListOf<UsersResponseItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ApiListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(responseList[position]) {
            holder.binding.tvGender.text = "No gender in api"
            holder.binding.tvName.text = name
            holder.binding.tvLocation.text = address?.city
            holder.binding.tvEmail.text = email
            holder.binding.tvLogin.text = username
            holder.binding.tvDOB.text = "No dob in api?"
            holder.binding.tvPicture.text = website
            holder.binding.tvPhone.text = phone
            holder.binding.tvCell.text = company?.name
            holder.binding.tvId.text = id.toString()
            holder.binding.tvPicture.text = company?.bs
            holder.binding.tvNat.text = address?.street
        }
    }

    override fun getItemCount(): Int {
        return responseList.size
    }

    fun setList(list: List<UsersResponseItem>) {
        responseList.clear()
        responseList.addAll(list)
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ApiListBinding) : RecyclerView.ViewHolder(binding.root)
}