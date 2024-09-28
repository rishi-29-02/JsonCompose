package com.androidnerds.mycomposeapplication.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.androidnerds.mycomposeapplication.models.Quote

@Composable
fun QuoteListScreen(data: List<Quote>, onClick: (quote:Quote) -> Unit) {

    Column(modifier = Modifier.padding(10.dp)) {
        Text(
            text = "Quotes App",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h4
        )

        QuoteList(data = data, onClick )
    }
}