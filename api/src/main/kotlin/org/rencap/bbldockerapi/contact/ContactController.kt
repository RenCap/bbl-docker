package org.rencap.bbldockerapi.contact

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/contacts")
@CrossOrigin
class ContactController(
        private val contactRepository: ContactRepository,
        private val contactMapper: ContactMapper) {

    @GetMapping
    fun getContacts(): List<ContactDto> {
        return contactRepository.findAll()
                .map { contact -> contactMapper.contactToContactDto(contact) }
                .sortedWith(compareBy(ContactDto::lastName, ContactDto::firstName))
    }
}