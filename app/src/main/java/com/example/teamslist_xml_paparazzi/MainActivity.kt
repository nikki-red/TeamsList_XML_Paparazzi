package com.example.teamslist_xml_paparazzi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.fragment.app.Fragment
import com.example.mylibrary.ChatFragment
import com.example.mylibrary.Group
import com.example.mylibrary.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.mylibrary.R
import com.example.mylibrary.RvAdapter
import com.example.mylibrary.SettingsFragment
import com.example.mylibrary.databinding.ActivityMainBinding

import androidx.appcompat.widget.Toolbar
import com.example.mylibrary.databinding.RecyclerViewListBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private var groupList = ArrayList<Group>()
    private lateinit var rvAdapter: RvAdapter

    //lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        //val mergeBinding =
        setContentView(binding.root)
        //loadFragment(HomeFragment())
/*
        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.message -> {
                    loadFragment(ChatFragment())
                    true
                }
                R.id.settings -> {
                    loadFragment(SettingsFragment())
                    true
                }

                else -> {
                    false
                }
            }
        }
 */
//        val binding1 = RecyclerViewListBinding.inflate(layoutInflater)
//        val mergedBinding = MergeBinding(binding1, binding2)
//        val recyclerView = binding.groupList
        binding.recyclerViewListId.groupList.layoutManager = LinearLayoutManager(this)
        //binding.groupList.layoutManager = LinearLayoutManager(this)

        rvAdapter = RvAdapter(groupList)
        //binding.groupList.adapter = rvAdapter
        binding.recyclerViewListId.groupList.adapter = rvAdapter

        val group1 = Group("Group 1", "Desc 1", false)
        val group2 = Group("Group 2", "Desc 2", false)
        val group3 = Group("Group 3", "Desc 3", false)
        val group4 = Group("Group 4", "Desc 4", false)
        val group5 = Group("Group 5", "Desc 5", false)
        val group6 = Group("Group 6", "Desc 6", false)
        val group7 = Group("Group 7", "Desc 7", false)

        groupList.add(group1)
        groupList.add(group2)
        groupList.add(group3)
        groupList.add(group4)
        groupList.add(group5)
        groupList.add(group6)
        groupList.add(group7)

        rvAdapter.notifyDataSetChanged()

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
/*
    private  fun loadFragment(fragment: HomeFragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }

 */
}