package br.com.fiap.credmail.model;


import java.time.LocalDateTime;
import java.util.Date;

data class EventoCalendario(
        val data:Date= "",
        val local: String = "",
        val horarioInicio:String,
        val horarioFim: String,
        val descricao: String = "",
)


