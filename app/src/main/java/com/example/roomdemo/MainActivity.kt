package com.example.roomdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Integer.valueOf(android.os.Build.VERSION.SDK)
        Log.e("TAG", "onCreate: ${Integer.valueOf(android.os.Build.VERSION.SDK)}")

        database = ContactDatabase.getDatabase(this)

        GlobalScope.launch {
            database.contactDao().insertContact(ContactEntity(0, "John", "12345768", Date()))
            database.contactDao().deleteContact(ContactEntity(4,"John","12345768", Date()))
            database.contactDao().updateContact(ContactEntity(2,"Abrahim","12345678",Date()))

        }

    }

    fun getData(view: View) {
        database.contactDao().getContact().observe(this) {
            Log.e("TAG", "getData: ${it.toString()}")

        }
    }
}