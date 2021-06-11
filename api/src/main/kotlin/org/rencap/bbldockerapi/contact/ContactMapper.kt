package org.rencap.bbldockerapi.contact

import org.springframework.stereotype.Component

interface ContactMapper {
    fun contactToContactDto(contact: Contact): ContactDto
    fun contactDtoToContact(contactDto: ContactDto): Contact
}

@Component
class ContactMapperImpl : ContactMapper {
    override fun contactToContactDto(contact: Contact): ContactDto {
        return ContactDto(contact.id, contact.firstName, contact.lastName, contact.email)
    }

    override fun contactDtoToContact(contactDto: ContactDto): Contact {
        return Contact(contactDto.id, contactDto.firstName, contactDto.lastName, contactDto.email)
    }
}