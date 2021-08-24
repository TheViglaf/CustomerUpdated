package com.devtest.customer.service

import com.devtest.customer.dto.NewContactsDto
import com.devtest.customer.model.Contact
import com.devtest.customer.model.Customer
import org.springframework.stereotype.Service
import java.util.ArrayList

@Service
class ContactsService (private var customer: Customer) {

    fun list(): List<Contact>? {
        return customer.contact

    }

    fun searchById(customerid: Long, id: Long): Contact {
        return customer.contact.stream().filter { c ->
            c.id == id
        }.findFirst().get()

    }

    fun create(dto: NewContactsDto) {
        customer.contact = customer.contact.plus(
            Contact(
                id = customer.contact.size.toLong() + 1,
                phone = dto.phone,
                email = dto.email
            )
        )
    }

    fun delete(id: Long) {
        val contact = customer.contact.stream().filter { t ->
            t.id == id
        }.findFirst().get()
        customer.contact = customer.contact.minus(contact)
    }


}
