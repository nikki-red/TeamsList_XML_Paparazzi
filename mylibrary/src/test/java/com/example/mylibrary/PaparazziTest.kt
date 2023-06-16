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
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.teamslist_xml_paparazzi.MainActivity

class PaparazziTest {
    @get:Rule
    var paparazzi = Paparazzi(
        deviceConfig = PIXEL_3,
        theme = "Theme.MaterialComponents.Light"
    )

    @Test
    fun testEntireMusicApp() {
        val view = paparazzi.inflate<ConstraintLayout>(R.layout.activity_main)
        paparazzi.snapshot(view)
    }
/*
    @Test
    fun testToolbar() {
        val view = paparazzi.inflate<ConstraintLayout>(R.layout.activity_main)
        val toolbar = view.findViewById<Toolbar>(R.id.topBar)

        paparazzi.snapshot(toolbar)
    }

 */

    @Test
    fun testRecyclerView() {
        val view = paparazzi.inflate<ConstraintLayout>(R.layout.activity_main)
        val recyclerView = view.findViewById<RecyclerView>(R.id.groupList)

        paparazzi.snapshot(recyclerView)
    }


}