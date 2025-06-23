package com.example.ottapplication

import android.content.Context
import android.content.SharedPreferences
import android.media.AudioManager
import android.media.AudioManager.RINGER_MODE_SILENT
import com.ott.ottapplication.utils.StringHandler
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock


@RunWith(MockitoJUnitRunner::class)
class MockContextText {

    private val FAKE_STRING = "HELLO"

    @Mock
    private lateinit var mockedContext: Context

    @Mock
    private lateinit var sharedPreferences: SharedPreferences

    @Before
    fun initMocks() {
//        val mockedContext = mock<Context>() {
//            on { getString(R.string.app_name) } doReturn FAKE_STRING
//        }
        //sharedPreferences = mockedContext.getSharedPreferences("BOOKMARK", Context.MODE_PRIVATE)
    }

    @Test
    fun compareString() {
      //  Mockito.`when`(sharedPreferences.getString("BOOKMARK", "")).thenReturn("success")
      //  assertEquals(Pref(mockedContext).getToken(), "success")
    }

    @Test
    fun compareTestString() {
//        val mockedContext = mock<Context>() {
//            on { getString(R.string.app_name) } doReturn FAKE_STRING
//        }
//
//        val obj = StringHandler(mockedContext)
//        assertEquals(obj.getName(), FAKE_STRING)
    }

    @Test
    fun compareTestImage() {
//        val mocked = mock<Context> {
//            on { getString(R.string.title_dashboard) } doReturn FAKE_STRING
//        }
//        val obj = StringHandler(mocked)
//        assertNotEquals(obj.getText(), "sss")
    }

    @Test
    fun testAudio(){
        val audioManager = Mockito.mock(AudioManager::class.java)
        Mockito.`when`(audioManager.ringerMode)
            .thenReturn(RINGER_MODE_SILENT)
        // Test the function we need to

        assertEquals(Mockito.verify(audioManager).ringerMode,RINGER_MODE_SILENT)
        Mockito.verifyNoInteractions(audioManager)

    }

}