package com.example.ottapplication

import android.view.View
import android.widget.LinearLayout
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.isDialog
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.ott.ottapplication.R
import com.ott.ottapplication.ui.details.DetailsActivity
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class EspressoTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(DetailsActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.myapplication", appContext.packageName)
    }

    @Test
    fun loadText(){
        onView(withText("Hello Espresso")).check(matches(isDisplayed()))
      //  onView(withId(R.id.text_home)).check(matches(isDisplayed()))
      //  onView(withId(R.id.text_home)).check(matches(isEnabled()))

        


//        onView(withRecyclerView(R.id.recycler_view)
//            .atPositionOnView(1, R.id.ofElementYouWantToCheck))
//            .check(matches(withText("Test text")));
//
//        onView(withId(R.id.text_home)).perform(click()).check(matches(object :TypeSafeMatcher<View>(){
//            override fun describeTo(description: Description?) {
//
//            }
//
//            override fun matchesSafely(item: View?): Boolean {
//               return false
//            }
//
//        }))
//
//        onData(withText("Hello")).onChildView(withId(R.id.text_home)).atPosition(0).check(matches(
//           object :TypeSafeMatcher<View>(){
//               override fun describeTo(description: Description?) {}
//
//               override fun matchesSafely(item: View?): Boolean {
//
//                   if(item is LinearLayout){
//                       return item.childCount ==0
//                   }
//
//                  return false
//               }
//
//           }
//        ))

        onView(withText("tatoo")).check(matches(isDisplayed()))

        onData(withText("Hello")).inAdapterView(withId(R.id.button)).perform(click())
        //onData(withId(R.id.text_home)).inRoot(isDialog())
        onView(withText("")).perform(click())
        onView(withText("Hello")).check(matches( isDisplayed()))

        onData(withText("hello")).inRoot(isDialog()).check(matches(isDisplayed()))

    }





}