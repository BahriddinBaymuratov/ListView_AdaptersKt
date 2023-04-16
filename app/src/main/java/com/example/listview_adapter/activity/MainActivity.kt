package com.example.listview_adapter.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.listview_adapter.R
import com.example.listview_adapter.databinding.ActivityMainBinding
import com.example.listview_adapter.databinding.ItemContactBinding
import com.example.listview_adapter.model.Contact

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var contactList: List<Contact>? = null         // 1- misol uchun
    private var stringList: List<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//        loadContactFirst()  // 1 - misol
//        loadContactUiFirst()    // 1 - misol

        loadContactSecond()   // 2 - misol
        loadContactUiSecond()  // 2 - misol

    }

    private fun loadContactFirst() {
        contactList = ArrayList() // 1 - misol
        for (i in 0..99) {
            (contactList as ArrayList<Contact>).add(Contact("Android -> $i", "+998934322234 $i"))
        }
    }

    private fun loadContactUiFirst() {   // 1 - misol
        for (i in contactList?.indices!!) {
            val itemContactBinding = ItemContactBinding.inflate(layoutInflater)
            itemContactBinding.nameTv.text = contactList!![i].name
            itemContactBinding.numberTv.text = contactList!![i].number
            binding.layout.addView(itemContactBinding.root)

            itemContactBinding.root.setOnClickListener {
                Toast.makeText(this, contactList!![i].name, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loadContactUiSecond() {
        val list = arrayOf(
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"
        )
        val arAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)

//        val itemLayout = layoutInflater.inflate(R.layout.item_layout, binding.listView, false) as ViewGroup
//        binding.listView.addFooterView(itemLayout)

        binding.listView.adapter = arAdapter
    }

    private fun loadContactSecond() { // 2 -misol
        for (i in 0..99) {
            (stringList as ArrayList<String>).add("Android -> " + i)
        }
    }
}
