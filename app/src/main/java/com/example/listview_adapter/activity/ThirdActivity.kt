package com.example.listview_adapter.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listview_adapter.R
import com.example.listview_adapter.databinding.ActivityThirdBinding
import com.example.listview_adapter.model.Contact

class ThirdActivity : AppCompatActivity() {
    private val binding by lazy { ActivityThirdBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val user = intent.getParcelableExtra<Contact>("contact")

        user?.let {
            binding.text1.text = it.name
            binding.text2.text = it.number
        }

    }
}