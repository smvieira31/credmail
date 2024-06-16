package br.com.fiap.credmail.service

import android.app.usage.UsageEvents
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import java.time.LocalDateTime
import java.util.Date


interface CalendarService {

    @POST("calendars/{calendarId}/events")
    suspend fun createEvent(
        @Path("calendarId") calendarId: String,
        @Path("local") local: String,
        @Path("data") data: Date,
        @Path("horarioInicio") horarioInicio: String,
        @Path("horarioFim") horarioFim: String,
        @Path("descricao") descricao: String,
        @Body event: UsageEvents.Event
    ): UsageEvents.Event
}




    @GET("calendars/{calendarId}/events")
    suspend fun createEvent(
        @Path("calendarId") calendarId: String,
        @Path("local") local: String,
        @Path("data") data: Date,
        @Path("horarioInicio") horarioInicio: LocalDateTime,
        @Path("horarioFim") horarioFim: LocalDateTime,
        @Path("descricao") descricao: String,
        @Body event: UsageEvents.Event) {
    }
