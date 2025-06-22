package com.example.myapplication.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 * All activity having Ui must extend this BaseActivity...
 * Also need to specify the viewBinding as well.
 */
abstract class BaseActivity<T> : AppCompatActivity() {

    var binding: T? = null

    abstract fun  getViewBinding(): T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView((binding as ViewBinding).root)

    }

}