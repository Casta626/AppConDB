package com.example.entregable2fragmentos

object CustomerObject {
    val retrofitService: DataCustomerService by lazy { retrofit.create(DataCustomerService::class.java) }
}