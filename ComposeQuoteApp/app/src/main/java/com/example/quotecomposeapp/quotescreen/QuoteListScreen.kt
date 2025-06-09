package com.example.quotecomposeapp.quotescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.quotecomposeapp.datamodels.Quote

@Composable
fun QuoteListScreen(quotes: List<Quote>, onClick: (quote: Quote) -> Unit) {
    Column {
        Text(
            text = "Quote App", textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
                .fillMaxWidth(1f),
            style = MaterialTheme.typography.headlineLarge
        )
        QuoteList(quotes, onClick)
    }
}