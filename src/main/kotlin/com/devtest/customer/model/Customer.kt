package com.devtest.customer.model

import java.util.*

data class Customer(
        var id: Long?,
        var name: String,
        var phone: String,
        var address: String,
        var contact: List<Contact> = ArrayList<Contact>()
)
