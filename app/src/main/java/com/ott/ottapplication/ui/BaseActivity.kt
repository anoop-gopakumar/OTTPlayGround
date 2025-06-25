package com.ott.ottapplication.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 * All activity having Ui must extend this BaseActivity...
 * Also need to specify the viewBinding as well.
 */
abstract class BaseActivity<T> : AppCompatActivity() {

    var binding: T? = null

    abstract fun getViewBinding(): T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView((binding as ViewBinding).root)

    }

    fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}