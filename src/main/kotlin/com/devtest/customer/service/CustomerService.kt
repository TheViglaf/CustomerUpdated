package com.devtest.customer.service

import com.devtest.customer.dto.NewContactsDto
import com.devtest.customer.dto.NewCustomerDto
import com.devtest.customer.model.Contact
import com.devtest.customer.model.Customer
import org.springframework.stereotype.Service
import java.util.*

@Service
class CustomerService(private var customers: List<Customer> = ArrayList<Customer>()) {

//    init {
//        val contact1 = Contact (
//                id = 1,
//                phone = "String",
//                email = "ronaldo"
//
//                )
//        val contact2 = Contact (
//            id = 2,
//            phone = "String",
//            email = "ronaldo"
//
//        )
//        val contact3 = Contact (
//            id = 3,
//            phone = "String",
//            email = "ronaldo"
//
//        )
//        val contacts:List<Contact> = listOf(contact1, contact2, contact3)
//        val customer = Customer(
//            id = 1,
//            name = "ronaldo",
//            phone = "55663322",
//            address = "itaquera",
//            contact = contacts
//        )
//        val customer2 = Customer(
//            id = 2,
//            name = "ronaldo",
//            phone = "55663322",
//            address = "itaquera",
//            contact = contacts
//        )
//        val customer3 = Customer(
//            id = 3,
//            name = "ronaldo",
//            phone = "55663322",
//            address = "itaquera",
//            contact = contacts
//        )
//        customers =  Arrays.asList(customer, customer2, customer3)
//    }

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
                id = customers.size.toLong() + 1,
                name = dto.name,
                phone = dto.phone,
                address = dto.address,
                contact = ArrayList()
        ))

    }

    fun update(id: Long, dto: NewCustomerDto){
        var customer = customers.stream().filter { t ->
            t.id == id
        }.findFirst().get()
       customers =  customers.minus(customer)
        customer.id = id
        customer.address = dto.address
        customer.name = dto.name
        customer.phone = dto.phone
        customers = customers.plus(customer)
    }

    fun delete(id: Long) {
        val customer = customers.stream().filter { t ->
            t.id == id
        }.findFirst().get()
        customers = customers.minus(customer)
    }

    fun list(id: Long): List<Contact> {
        return searchById(id).contact

    }
    fun searchById(id: Long, contactid: Long): Contact {
        return searchById(id).contact.stream().filter { t -> t.id == contactid }.findFirst().get()

    }

    fun create(id: Long, dto: NewContactsDto) {
        val customer = searchById(id)
        customers.minus(customer)
        customer.contact = customer.contact.plus(
                Contact(
                        id = customer.contact.size.toLong() + 1,
                        phone = dto.phone,
                        email = dto.email
                )

        )
        customers.plus(customer)

    }

    fun update(id: Long, contactId: Long, dto: NewContactsDto){
        var customer = customers.stream().filter { t ->
            t.id == id
        }.findFirst().get()

        var contact = customer.contact.stream().filter { t ->
            t.id == contactId}.findFirst().get()

        customers = customers.minus(customer)

        customer.contact = customer.contact.minus(contact)

        contact.id = contactId
        contact.email = dto.email
        contact.phone = dto.phone

        customer.contact = customer.contact.plus(contact)
        customers = customers.plus(customer)
    }

    fun delete(id: Long, contactid: Long) {
        var customer = searchById(id)
        customers = customers.minus(customer)
        var contact = customer.contact.stream().filter { t ->
            t.id == contactid
        }.findFirst().get()

        customer.contact = customer.contact.minus(contact)
        customers = customers.plus(customer)
    }
}