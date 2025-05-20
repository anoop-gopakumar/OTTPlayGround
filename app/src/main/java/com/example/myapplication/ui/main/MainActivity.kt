package com.example.myapplication.ui.main

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication.utils.programs.Palindrome
import com.example.myapplication.R
import com.example.myapplication.utils.programs.SecondLargest
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.ui.BaseActivity
import com.example.myapplication.utils.programs.BubbleSort
import com.example.myapplication.utils.programs.FindMostDuplicatedString

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpNavigation()
        loadPrograms()
    }

    private fun setUpNavigation() {
        val navView: BottomNavigationView = binding?.navView!!
        val navController = findNavController(R.id.nav_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    private fun loadPrograms() {
        FindMostDuplicatedString().findMostDuplicated("aabbcccddd")
        SecondLargest().findSecondLargest()
        Palindrome().findPalindrome()

        val array = intArrayOf(5, 6, 1, 3)
        BubbleSort().sort(array)

        val creator = ::sum
        val sum = creator(10, 30)
        println(" Sum is "+ ::sum)
    }

    fun sum(x: Int, y: Int) :Int {
        return x+y
    }


    private fun threadAndHandler(){
        val h: Handler = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                if (msg.what == 0) {
                    //  updateUI()
                } else {
                    //  showErrorDialog()
                }
            }
        }

        val t = object : Thread() {
            override fun run() {
                // val success= doSomeWork()
                h.sendEmptyMessage(0);
            }
        }
    }
}