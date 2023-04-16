package com.example.listview_adapter.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.BaseAdapter
import com.example.listview_adapter.databinding.ItemLayoutBinding
import com.example.listview_adapter.model.Contact

class ContactBaseAdapter(
    private val contactList: List<Contact>,
    private val listener: OnItemClickListener
) : BaseAdapter() {

    override fun getCount(): Int {
        return contactList.size
    }

    override fun getItem(i: Int): Contact {
        return contactList[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
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

        binding.btnDelete.setOnClickListener {
            listener.onItemDelete(contact, position) }

        binding.btnEdit.setOnClickListener {
            listener.onItemEdit(contact, position) }

        return binding.root
    }

    interface OnItemClickListener {
        fun onItemDelete(contact: Contact?, position: Int)
        fun onItemEdit(contact: Contact?, position: Int)
    }

    companion object {
        private const val TAG = "ContactBaseAdapter"
    }
}