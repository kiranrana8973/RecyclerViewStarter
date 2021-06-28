package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.recyclerview.model.Employee

class ProfileActivity : AppCompatActivity() {
    private lateinit var imgProfile : ImageView
    private lateinit var tvName : EditText
    private lateinit var tvSalary : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        imgProfile = findViewById(R.id.imgProfile)
        tvName = findViewById(R.id.tvName)
        tvSalary = findViewById(R.id.tvSalary)

        // Retrieve the value passed from MainActivity
        val intent = intent.getParcelableExtra<Employee>("employee")
        if(intent!=null){
            tvName.setText(intent.name)
            tvSalary.text = intent.salary.toString()
            Glide.with(this)
                .load(intent.imageUrl)
                .circleCrop()
                .into(imgProfile)
        }else{
            Toast.makeText(this, "No value received", Toast.LENGTH_SHORT).show()
        }

    }
}