package br.com.fiap.credmail.service

import retrofit2.Retrofit

class Retrofitservice {

    private val URL = "https://www.googleapis.com/calendar/v3"
    private val API_KEY = "AIzaSyCM3rMaGNN3nIlVKtdvUwR1cwHsTYd5Ybs"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL)
        .build()

    fun getEventService():  CalendarService {
        return retrofitFactory.create(CalendarService::class.java)

    }
}
