package com.devtest.customer.controller

import com.devtest.customer.dto.NewContactsDto
import com.devtest.customer.model.Contact
import com.devtest.customer.service.ContactsService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/customers/{customerid}/contacts")
class ContactsController (private val service: ContactsService){

    @GetMapping
    fun list(): List<Contact>? {
        return service.list()
    }

    @GetMapping("/{id}")
    fun searchById(@PathVariable customerid:Long,@PathVariable id: Long): Contact{
        return service.searchById(customerid, id)

    }

    @PostMapping
    fun create(@RequestBody dto: NewContactsDto){
        service.create(dto)
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        service.delete(id)
    }
}