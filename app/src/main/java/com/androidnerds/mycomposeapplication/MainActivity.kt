package com.androidnerds.mycomposeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.androidnerds.mycomposeapplication.screens.QuoteListScreen
import com.androidnerds.mycomposeapplication.screens.QuotesDetail
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadAssetsFromFile(applicationContext)
        }

        setContent {
            app()
        }
    }
}

@Composable
fun app() {
    if (DataManager.isDataLoaded.value) {
        if (DataManager.currentPage.value == Page.LIST) {
            QuoteListScreen(data = DataManager.data) {
                DataManager.switchPages(it)
            }
        } else {
            DataManager.currentQuote?.let { QuotesDetail(quote = it) }
        }
    }
}

enum class Page {
    LIST,
    DETAIL
}