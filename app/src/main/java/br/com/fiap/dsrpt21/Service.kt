package br.com.fiap.dsrpt21

import retrofit2.Call
import retrofit2.http.GET

interface Service {

    @GET("/advice")
    fun getAdvices(): Call<Advice>

}