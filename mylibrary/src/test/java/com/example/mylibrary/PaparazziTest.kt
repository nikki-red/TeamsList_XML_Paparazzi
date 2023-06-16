package com.example.mylibrary

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageInstaller
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import app.cash.paparazzi.DeviceConfig.Companion.PIXEL_3
import app.cash.paparazzi.Paparazzi
import com.example.mylibrary.databinding.ActivityMainBinding
import com.google.android.material.card.MaterialCardView
import org.junit.Rule
import org.junit.Test
import android.view.LayoutInflater
import android.view.ViewTreeObserver
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.rules.ActivityScenarioRule
import app.cash.paparazzi.DeviceConfig
import com.android.ide.common.rendering.api.SessionParams
import com.example.teamslist_xml_paparazzi.MainActivity
import com.example.mylibrary.RvAdapter
import com.example.mylibrary.databinding.AppBarMainBinding
import com.example.mylibrary.databinding.SingleItemBinding
import com.google.android.material.appbar.MaterialToolbar

class PaparazziTest {
    @get:Rule
    var paparazzi = Paparazzi(
        deviceConfig = PIXEL_3,
        theme = "Theme.MaterialComponents.Light"
    )
/*
    @Test
    fun testEntireMusicApp() {
        val binding = ActivityMainBinding.inflate(paparazzi.layoutInflater)
        paparazzi.snapshot(binding.root)
    }
 */
    @Test
    fun testToolbar() {
        val binding = AppBarMainBinding.inflate(paparazzi.layoutInflater)
        //val toolbar = binding.root.findViewById<MaterialToolbar>(R.id.topBar)
        paparazzi.snapshot(binding.root)
    }

    @Test
    fun testSingleItem() {
        val binding = SingleItemBinding.inflate(paparazzi.layoutInflater)
        paparazzi.snapshot(binding.root)
    }

    private var groupList = ArrayList<Group>()
    private lateinit var rvAdapter: RvAdapter
    @Test
    fun testEntireActivity() {
        val binding = ActivityMainBinding.inflate(paparazzi.layoutInflater)
        /*
        val recyclerView = binding.groupList

        rvAdapter = RvAdapter(groupList)
        recyclerView.adapter = rvAdapter

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

        //rvAdapter.notifyDataSetChanged()
*/
        paparazzi.snapshot(binding.root)
    }

    @Test
    fun testExpandedSingleItemOfWhole() {
        val binding = ActivityMainBinding.inflate(paparazzi.layoutInflater)
        val recyclerView = binding.groupList

        rvAdapter = RvAdapter(groupList)
        recyclerView.adapter = rvAdapter

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

        val itemViewHolder = recyclerView.findViewHolderForAdapterPosition(0)
        val itemView = itemViewHolder?.itemView
        itemView?.performClick()
        paparazzi.snapshot(binding.root)
    }
}