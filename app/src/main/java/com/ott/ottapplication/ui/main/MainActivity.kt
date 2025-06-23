package com.ott.ottapplication.ui.main

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.ott.ottapplication.dsprograms.programs.Palindrome
import com.ott.ottapplication.R
import com.ott.ottapplication.dsprograms.programs.SecondLargest
import com.ott.ottapplication.ui.BaseActivity
import com.ott.ottapplication.utils.Shape
import com.ott.ottapplication.dsprograms.programs.BubbleSort
import com.ott.ottapplication.dsprograms.FindMostDuplicatedString
import com.ott.ottapplication.databinding.ActivityMainBinding

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
        println(" Sum is " + ::sum)


        var circle = Shape.Circle(20)
        var square = Shape.Square(20)
        var rectangle = Shape.Rectangle(20, 50)

        checkShape(rectangle)

    }

    private fun checkShape(shape: Shape) {
        val area: Int = when (shape) {
            is Shape.Circle -> (shape.radius * 2 * 3.14).toInt()
            is Shape.Square -> shape.side * shape.side
            is Shape.Rectangle -> shape.length * shape.breadth
            is Shape.Rect -> Int.MIN_VALUE
        }

        Log.d("TAG", "checkShape: area is ${area}")
    }

    private fun sum(x: Int, y: Int): Int {
        return x + y
    }

    private fun threadAndHandler() {
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