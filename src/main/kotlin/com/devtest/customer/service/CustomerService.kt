package com.devtest.customer.service

import com.devtest.customer.dto.NewContactsDto
import com.devtest.customer.dto.NewCustomerDto
import com.devtest.customer.model.Contact
import com.devtest.customer.model.Customer
import org.springframework.stereotype.Service
import java.util.*

@Service
class CustomerService(private var customers: List<Customer> = ArrayList()) {

    init {
        val contact1 = Contact (
                id = 1,
                phone = "String",
                email = "ronaldo"

                )
        val contact2 = Contact (
            id = 2,
            phone = "String",
            email = "ronaldo"

        )
        val contact3 = Contact (
            id = 3,
            phone = "String",
            email = "ronaldo"

        )
        val contacts:List<Contact> = listOf(contact1, contact2, contact3)
        val customer = Customer(
            id = 1,
            name = "ronaldo",
            phone = "55663322",
            address = "itaquera",
            contact = contacts
        )
        val customer2 = Customer(
            id = 2,
            name = "ronaldo",
            phone = "55663322",
            address = "itaquera",
            contact = contacts
        )
        val customer3 = Customer(
            id = 3,
            name = "ronaldo",
            phone = "55663322",
            address = "itaquera",
            contact = contacts
        )
        customers =  Arrays.asList(customer, customer2, customer3)
    }

    fun list(): List<Customer> {
        return customers

    }

    fun searchById(id: Long): Customer {
        return customers.stream().filter { c ->
            c.id == id
        }.findFirst().get()

    }

    fun create(dto: NewCustomerDto) {
        customers = customers.plus(Customer(
            id = customers.size.toLong()+1,
            name = dto.name,
            phone = dto.phone,
            address = dto.address,
            contact = ArrayList()
        ))

    }


    fun delete(id: Long) {
        val topico = customers.stream().filter { t ->
        t.id == id
    }.findFirst().get()
        customers = customers.minus(topico)
    }

    fun searchById(id: Long, contactid: Long): Contact {
        return searchById(id).contact.stream().filter { t -> t.id == contactid }.findFirst().get()

    }

    fun create(id: Long, dto: NewContactsDto) {
        val list = searchById(id)
        list.contact = list.contact.plus(
            Contact(
                id = list.contact.size.toLong() + 1,
                phone = dto.phone,
                email = dto.email
            )

        )
        customers = list
    }
    fun delete(id: Long, contactid: Long) {
        val listaa =
    }
        val contact = customer.contact.stream().filter { t ->
            t.id == id
        }.findFirst().get()
        customer.contact = customer.contact.minus(contact)

}