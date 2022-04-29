package com.prproject.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation

import androidx.navigation.ui.AppBarConfiguration

import androidx.navigation.ui.NavigationUI

import com.prproject.R

class NewsActivity : AppCompatActivity() {

    private var mNavigationController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mNavigationController = Navigation.findNavController(this, R.id.nav_host_fragment)
        val configuration: AppBarConfiguration = AppBarConfiguration.Builder(mNavigationController!!.graph).build()
        NavigationUI.setupActionBarWithNavController(this, mNavigationController!!, configuration)
    }

}
