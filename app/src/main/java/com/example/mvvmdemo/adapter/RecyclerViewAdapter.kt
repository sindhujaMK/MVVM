package com.example.mvvmdemo.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmdemo.R
import com.example.mvvmdemo.model.ServicesSetterGetter

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private  var responseList: List<ServicesSetterGetter.Results>  = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.api_list, parent, false)
        return ViewHolder(item)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val api = responseList[position]

        holder.gender.text = api.gender
        holder.name.text = api.name.first
        holder.location.text = api.location.city
        holder.email.text = api.email
        holder.login.text = api.login.username
        holder.dob.text = api.dob.date
        holder.registered.text = api.registered.date
        holder.phone.text = api.phone
        holder.cell.text = api.cell
        holder.id.text = api.id.value
        holder.picture.text = api.picture.large
        holder.nat.text = api.nat
    }

    override fun getItemCount(): Int {
        return responseList.size
    }

    fun setList(appName: List<ServicesSetterGetter.Results>) {
        responseList = appName
        notifyDataSetChanged()
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val gender = itemView.findViewById(R.id.tvGender) as TextView
        val name = itemView.findViewById(R.id.tvName) as TextView
        val location = itemView.findViewById(R.id.tvLocation) as TextView
        val email = itemView.findViewById(R.id.tvEmail) as TextView
        val login = itemView.findViewById(R.id.tvLogin) as TextView
        val dob = itemView.findViewById(R.id.tvDOB) as TextView
        val registered = itemView.findViewById(R.id.tvRegistered) as TextView
        val phone = itemView.findViewById(R.id.tvPhone) as TextView
        val cell = itemView.findViewById(R.id.tvCell) as TextView
        val id = itemView.findViewById(R.id.tvId) as TextView
        val picture = itemView.findViewById(R.id.tvPicture) as TextView
        val nat = itemView.findViewById(R.id.tvNat) as TextView
    }
}