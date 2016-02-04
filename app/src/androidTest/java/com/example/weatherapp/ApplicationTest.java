package com.example.weatherapp;

import android.app.Application;
import android.os.SystemClock;
import android.support.test.rule.ActivityTestRule;
import android.test.ApplicationTestCase;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import android.test.suitebuilder.annotation.LargeTest;
import org.junit.Rule;
import com.example.weatherapp.activities.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.typeTextIntoFocusedView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;


/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
@SuppressWarnings("deprecation")
public class ApplicationTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void Task0() {
        SystemClock.sleep(10000);
    }

    @Test
    public void Task1() {
        onView(withContentDescription("More options")).perform(click());
        onView(withText("Settings")).perform((click()));
        onView(withText(R.string.preference_title)).check(matches(withText("Forecast Preference")));
    }

    @Test
    // accessing android resource id by using android.R.id
    public void Task2() {
        onView(withContentDescription("More options")).perform(click());
        onView(withText("Settings")).perform((click()));
        onView(withText("Set location")).perform(click());
        onView(withId(android.R.id.edit)).perform(click(), clearText(), typeText("New York, New York"));
        onView(withId(android.R.id.button1)).perform(click());
        //onView(hasSibling(withText("Set location"))).check(matches(withText("New York, New York")));
        //onView(withText(R.string.preference_zip_key)).check(matches(withText("New York, New York")));
        ///onView(withText("New York, New York")).check(matches(isDisplayed()));
        onView(allOf(hasSibling(withText("Set location")), withId((android.R.id.summary)))).check(matches(withText("New York, New York")));
    }

    @Test
    public void Task3() {
        SystemClock.sleep(5000);
        onView(withText("Today, Feb 4")).perform(swipeDown());
        SystemClock.sleep(5000);
    }
}