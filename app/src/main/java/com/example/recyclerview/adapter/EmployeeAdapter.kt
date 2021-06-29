package com.example.recyclerview.adapter

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerview.MainActivity
import com.example.recyclerview.ProfileActivity
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
        val btnDelete: ImageButton = view.findViewById(R.id.btnDelete)
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

        holder.btnDelete.setOnClickListener {
            MainActivity.lstEmployee.remove(employee)
            notifyDataSetChanged()
        }
        Glide.with(context)
            .load(employee.imageUrl)
            .circleCrop()
            .into(holder.imageProfile)

        holder.imageProfile.setOnClickListener {

            val intent = Intent(context, ProfileActivity::class.java)
            intent.putExtra("employee", employee)

            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return lstEmployee.size
    }

}