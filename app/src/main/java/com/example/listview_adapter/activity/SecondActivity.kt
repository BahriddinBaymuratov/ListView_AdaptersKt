package com.example.listview_adapter.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.listview_adapter.R
import com.example.listview_adapter.adapter.ContactAdapter
import com.example.listview_adapter.adapter.ContactBaseAdapter
import com.example.listview_adapter.databinding.ActivitySecondBinding
import com.example.listview_adapter.model.Contact

class SecondActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySecondBinding.inflate(layoutInflater) }
    private lateinit var contactList: ArrayList<Contact>
    private var contactBaseAdapter: ContactBaseAdapter? = null
    private var lastClickPosition = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViews()

    }

    private fun initViews() {
        contactList = ArrayList()
        contactBaseAdapter = ContactBaseAdapter(contactList, object :
            ContactBaseAdapter.OnItemClickListener {
            override fun onItemDelete(contact: Contact?, position: Int) {
                contactList.removeAt(position)
                contactBaseAdapter!!.notifyDataSetChanged()
            }

            override fun onItemEdit(contact: Contact?, position: Int) {
                binding.editName.setText(contact?.name)
                binding.editNumber.setText(contact?.number)
                lastClickPosition = position
            }

        })
        binding.userlist.adapter = contactBaseAdapter

        binding.userlist.setOnItemClickListener { _, _, i, _ ->
            val intent = Intent(this, ThirdActivity::class.java)
            intent.putExtra("contact", contactList[i])
            startActivity(intent)
        }

        binding.btnSave.setOnClickListener { view ->
            val name = binding.editName.text.toString()
            val number = binding.editNumber.text.toString()
            if (lastClickPosition != -1) {
                // edit
                contactList[lastClickPosition].name
                contactList[lastClickPosition].number
                lastClickPosition = -1
            } else {
                val c1 = Contact(name, number)
                contactList.add(c1)
            }
            contactBaseAdapter!!.notifyDataSetChanged()
            binding.editName.setText("")
            binding.editNumber.setText("")
        }

    }


}