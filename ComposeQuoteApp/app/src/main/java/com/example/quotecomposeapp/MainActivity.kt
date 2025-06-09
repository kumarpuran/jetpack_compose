package com.example.quotecomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.quotecomposeapp.apputils.QuoteDataManager
import com.example.quotecomposeapp.quotescreen.QuoteDetail
import com.example.quotecomposeapp.quotescreen.QuoteListScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        CoroutineScope(Dispatchers.IO).launch {
            delay(5000)
            val quoteDataManager = QuoteDataManager
            quoteDataManager.loadQuotes(applicationContext)
        }
        setContent {
            App()
        }
    }

    @Composable
    fun App() {
        if (QuoteDataManager.isQuoteLoaded.value){
            if (QuoteDataManager.currentPage.value == Pages.HOME){
                QuoteListScreen(quotes = QuoteDataManager.quotes, onClick = {
                    QuoteDataManager.switchPages(it)
                })
            } else{
                QuoteDataManager.currentQuote?.let { QuoteDetail(quote = it) }
            }

        }else{
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize(1f)) {
                Text("Loading....",
                    style = MaterialTheme.typography.bodyLarge)
            }
        }
    }

    enum class Pages{
        HOME,
        DETAIL
    }
}