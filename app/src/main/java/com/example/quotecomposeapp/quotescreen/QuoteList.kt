package com.example.quotecomposeapp.quotescreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.example.quotecomposeapp.datamodels.Quote

@Composable
fun QuoteList(data:List<Quote>, onClick:(quote:Quote)->Unit) {
    LazyColumn (content = {
        items(data.size) {
            QuoteListItem(data[it],onClick)
        }
    })
}