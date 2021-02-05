package com.example.nyarticles.framework.presentaion.articledetails

import android.os.Bundle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.nyarticles.R
import com.example.nyarticles.business.entites.ArticleDomainModel
import com.example.nyarticles.framework.presentaion.articlelist.utils.UiTestUtils.launchFragmentInHiltContainer
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class ArticalDetailsFragmentTest {

    private val article = ArticleDomainModel("TestDetails", null, "by", "date", "abstract")

    @Before
    fun setup() {
        val bundle = Bundle()
        bundle.putParcelable("article", article)
        bundle.putString("title", article.title)
        launchFragmentInHiltContainer<ArticalDetailsFragment>(bundle)
    }

    @Test
    fun test_articleDetailsFragment_visibile() {
        onView(withId(R.id.by))
            .check(matches(withText(article.byline)))
        onView(withId(R.id.title))
            .check(matches(withText(article.title)))
        onView(withId(R.id.body))
            .check(matches(withText(article.abstract)))
        onView(withId(R.id.published_date))
            .check(matches(withText(article.publishedDate)))

    }
}