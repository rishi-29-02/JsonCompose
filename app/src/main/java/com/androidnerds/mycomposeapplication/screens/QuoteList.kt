package com.androidnerds.mycomposeapplication.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.androidnerds.mycomposeapplication.models.Quote

@Composable
fun QuoteList(data: List<Quote>, onClick : (quote:Quote) -> Unit) {

    LazyColumn(content = {
        items(data) {
            QuotesListItem(quote = it, onClick )
        }
    }, modifier = Modifier.padding(10.dp))
}