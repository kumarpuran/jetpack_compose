package com.example.quotecomposeapp.apputils

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.quotecomposeapp.MainActivity
import com.example.quotecomposeapp.datamodels.Quote
import com.google.gson.Gson

object QuoteDataManager {

    var quotes = mutableListOf<Quote>()
    var isQuoteLoaded = mutableStateOf(false)
    var currentPage = mutableStateOf(MainActivity.Pages.HOME)
    var currentQuote :Quote? = null


    fun loadQuotes(context: Context) {

        val inputStream = context.assets.open("Quote.json")
        val size:Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer,Charsets.UTF_8)
        val gson = Gson()
        val quoteList = gson.fromJson(json,Array<Quote>::class.java)
        quotes.addAll(quoteList)
        isQuoteLoaded.value = true
    }

    fun switchPages(quote: Quote?){
        if (currentPage.value == MainActivity.Pages.HOME){
            currentQuote = quote
            currentPage.value = MainActivity.Pages.DETAIL
        }else{
            currentPage.value = MainActivity.Pages.HOME
        }
    }
}