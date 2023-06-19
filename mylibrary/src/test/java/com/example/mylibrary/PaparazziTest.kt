package com.example.mylibrary

import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.View
import android.view.View.GONE
import app.cash.paparazzi.DeviceConfig.Companion.PIXEL_3_XL
import app.cash.paparazzi.Paparazzi
import com.example.mylibrary.databinding.ActivityMainBinding
import org.junit.Rule
import org.junit.Test
import app.cash.paparazzi.DeviceConfig.Companion.PIXEL_XL
import com.example.mylibrary.databinding.AppBarMainBinding
import com.example.mylibrary.databinding.RecyclerViewListBinding
import com.example.mylibrary.databinding.SingleItemBinding

class PaparazziTest {
    @get:Rule
    var paparazzi = Paparazzi(
        deviceConfig = PIXEL_3_XL,
        theme = "Theme.MaterialComponents.Light.NoActionBar"
    )

    @Test
    fun testToolbar() {
        val binding = AppBarMainBinding.inflate(paparazzi.layoutInflater)
        paparazzi.snapshot(binding.root)
    }

    @Test
    fun testSingleItemClosed() {
        val binding = SingleItemBinding.inflate(paparazzi.layoutInflater)
        paparazzi.snapshot(binding.root)
    }

    @Test
    fun testSingleItemExpanded() {
        val binding = SingleItemBinding.inflate(paparazzi.layoutInflater)
        binding.expandedView.visibility = GONE
        paparazzi.snapshot(binding.root)
    }


    private var groupList = ArrayList<Group>()
    private lateinit var rvAdapter: RvAdapter

    private fun addGroupItems() {
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
    @Test
    fun testEntireActivity() {
        val binding = ActivityMainBinding.inflate(paparazzi.layoutInflater)
        val recyclerView = binding.recyclerViewListId.groupList

        rvAdapter = RvAdapter(groupList)
        recyclerView.adapter = rvAdapter

        addGroupItems()

        paparazzi.snapshot(binding.root)
    }

    @Test
    fun testRecyclerView() {
        val binding = RecyclerViewListBinding.inflate(paparazzi.layoutInflater)
        val recyclerView = binding.groupList
        rvAdapter = RvAdapter(groupList)
        recyclerView.adapter = rvAdapter

        addGroupItems()
        paparazzi.snapshot(binding.root)
    }

    @Test
    fun testExpandedRecyclerView() {
        val binding = RecyclerViewListBinding.inflate(paparazzi.layoutInflater)
        val recyclerView = binding.groupList

        rvAdapter = RvAdapter(groupList)
        recyclerView.adapter = rvAdapter

        addGroupItems()

        groupList[2].expand = true
        rvAdapter.notifyItemChanged(2)
        paparazzi.snapshot(binding.root)
    }
}
