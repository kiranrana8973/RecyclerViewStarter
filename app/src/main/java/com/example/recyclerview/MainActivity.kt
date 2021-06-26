package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerview.model.Employee

class MainActivity : AppCompatActivity() {

    private lateinit var lstEmployee: ArrayList<Employee>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        populateEmployee()

    }

    private fun populateEmployee() {

        lstEmployee.add(
            Employee(
                "Kiran", "Talchhikhel", 2000F,
                "https://avatars.githubusercontent.com/u/17020882?v=4"
            )
        )

        lstEmployee.add(
            Employee(
                "Anita", "Talchhikhel", 2000F,
                "data:image/jpeg;base64,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"
            )
        )
    }
}