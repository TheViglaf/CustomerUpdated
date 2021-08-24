package com.devtest.customer.model

data class Customer(
    val id: Long?,
    val name: String,
    val phone: String,
    val address: String,
    var contact: List<Contact> = ArrayList()
)
