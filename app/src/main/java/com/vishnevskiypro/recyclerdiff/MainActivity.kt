package com.vishnevskiypro.recyclerdiff

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.vishnevskiypro.recyclerdiff.databinding.ActivityMainBinding
import com.vishnevskiypro.recyclerdiff.model.UserService
import com.vishnevskiypro.recyclerdiff.model.UsersListener

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UsersAdapter

    private val usersService: UserService
        get() = (applicationContext as App).usersService


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        adapter = UsersAdapter()

        val linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = linearLayoutManager
        binding.recyclerView.adapter = adapter

        usersService.addListener(usersListener)

    }

    override fun onDestroy() {
        usersService.removeListener(usersListener)
        super.onDestroy()
    }

    private val usersListener: UsersListener = {
        adapter.users = it
    }
}