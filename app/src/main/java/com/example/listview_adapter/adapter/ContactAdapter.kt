package com.example.listview_adapter.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.listview_adapter.R
import com.example.listview_adapter.databinding.ItemLayoutBinding
import com.example.listview_adapter.model.Contact

class ContactAdapter(context: Context, private val contactList: List<Contact>) :
    ArrayAdapter<Contact?>(context, R.layout.item_layout, contactList) {
    override fun getCount(): Int {
        return contactList.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ItemLayoutBinding
        binding = if (convertView == null) {
            Log.d(TAG, "Create: $position")
            ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        } else {
            Log.d(TAG, "Update: $position")
            ItemLayoutBinding.bind(convertView)
        }
        val contact = contactList[position]
        binding.textName.text = contact.name
        binding.textNumber.text = contact.number
        return binding.root
    }

    companion object {
        const val TAG = "ContactAdapter"
    }
}