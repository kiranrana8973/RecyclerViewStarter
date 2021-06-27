package com.example.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerview.MainActivity
import com.example.recyclerview.R
import com.example.recyclerview.model.Employee


class EmployeeAdapter(
    val lstEmployee: ArrayList<Employee>,
    val context: Context
) : RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {

    // View holder
    class EmployeeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageProfile: ImageView = view.findViewById(R.id.imgProfile)
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvAddress: TextView = view.findViewById(R.id.tvAddress)
        val tvSalary: TextView = view.findViewById(R.id.tvSalary)
    }

    // ACTUAL KURSI BANAU
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.my_design, parent, false)

        return EmployeeViewHolder(view)
    }

    //Bhitra ko content lai change gara
    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        // euta employee lai extract garau
        val employee = lstEmployee[position]
        holder.tvName.text = employee.name
        holder.tvAddress.text = employee.address
        holder.tvSalary.text = employee.salary.toString()

        Glide.with(context)
            .load(employee.imageUrl)
            .into(holder.imageProfile)
    }

    override fun getItemCount(): Int {
        return lstEmployee.size
    }

}