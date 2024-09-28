package com.androidnerds.mycomposeapplication

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.androidnerds.mycomposeapplication.models.AllQuotes
import com.androidnerds.mycomposeapplication.models.Quote
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader

object DataManager {

    var data = emptyList<Quote>()
    var isDataLoaded = mutableStateOf(false)

    var currentQuote : Quote? = null

    var currentPage = mutableStateOf(Page.LIST)

    fun loadAssetsFromFile(context: Context) {

        val inputStream = context.assets.open("quotes.json")
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        val jsonString = bufferedReader.use { it.readText() }

        val quoteList = Gson().fromJson(jsonString, AllQuotes::class.java)
        data = quoteList.quotes
        isDataLoaded.value = true

    }

    fun switchPages(quote: Quote) {
        if (currentPage.value == Page.LIST) {
            currentPage.value = Page.DETAIL
            currentQuote = quote
        } else {
            currentPage.value = Page.LIST
        }
    }
}