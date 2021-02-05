package com.example.nyarticles.framework.presentaion.articlelist

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.contrib.RecyclerViewActions.*
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.nyarticles.R
import com.example.nyarticles.framework.presentaion.articlelist.ArticlesAdapter.ArticleHolder
import com.example.nyarticles.framework.presentaion.articlelist.utils.UiTestUtils.isRefreshing
import com.example.nyarticles.framework.presentaion.articlelist.utils.UiTestUtils.launchFragmentInHiltContainer
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class ArticleListFragmentTest {


    @Before
    fun setup() {
        launchFragmentInHiltContainer<ArticleListFragment>()
    }

    @Test
    fun test_ArticleListFragment_visibile() {
        onView(withId(R.id.swipeRef))
            .check(matches(isDisplayed()))
        onView(withId(R.id.swipeRef)).check(matches(isRefreshing()))
        onView(withId(R.id.articlesList)).check(matches((isDisplayed())))

    }
}