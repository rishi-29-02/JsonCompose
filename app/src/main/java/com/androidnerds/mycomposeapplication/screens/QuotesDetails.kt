package com.androidnerds.mycomposeapplication.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.androidnerds.mycomposeapplication.DataManager
import com.androidnerds.mycomposeapplication.Page
import com.androidnerds.mycomposeapplication.models.Quote

@Composable
fun QuotesDetail(quote: Quote) {

    BackHandler() {
        DataManager.currentPage.value = Page.LIST
    }

    Box(modifier = Modifier
        .fillMaxSize(1f)
        .background(
            Brush.sweepGradient(
                colors = listOf(
                    Color.White,
                    Color.LightGray,

                    )
            )
        ), contentAlignment = Alignment.Center) {

        Card(elevation = 4.dp, modifier = Modifier.padding(32.dp)) {

            Column(modifier = Modifier.padding(32.dp)) {
                Image(
                    imageVector = Icons.Filled.FormatQuote,
                    contentDescription = "",
                    modifier = Modifier
                        .rotate(180f)
                        .size(60.dp)
                )

                Text(
                    text = quote.text,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = quote.author,
                    fontWeight = FontWeight.Thin,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}