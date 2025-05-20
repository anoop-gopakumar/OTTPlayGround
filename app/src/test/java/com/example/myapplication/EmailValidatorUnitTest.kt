package com.example.myapplication

import com.example.myapplication.utils.EmailValidator
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class EmailValidatorUnitTest {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun validateEmail(){
       assertTrue(EmailValidator.isValidEmail("name@gm.com"))
    }



}