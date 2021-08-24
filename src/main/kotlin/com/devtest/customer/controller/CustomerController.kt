package com.devtest.customer.controller

import com.devtest.customer.dto.NewContactsDto
import com.devtest.customer.dto.NewCustomerDto
import com.devtest.customer.model.Contact
import com.devtest.customer.model.Customer
import com.devtest.customer.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/customers")
class CustomerController (private val service: CustomerService){

    @GetMapping
    fun list(): List<Customer> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun searchById(@PathVariable id: Long): Customer{
        return service.searchById(id)

    }

    @PostMapping
    fun create(@RequestBody dto: NewCustomerDto){
        service.create(dto)
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        service.delete(id)
    }

    @GetMapping("/customers/{id}/contacts/{contactid}")
    fun searchById(@PathVariable id:Long,@PathVariable contactid: Long): Contact {
        return service.searchById(id, contactid)

    }

    @PostMapping("/customers/{id}/contacts")
    fun create(@PathVariable id: Long, @RequestBody dto: NewContactsDto){
        service.create(id, dto)
    }



    @DeleteMapping("/customers/{id}/contacts/{contactid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long, contactid: Long) {
        service.delete(id, contactid)
    }
}