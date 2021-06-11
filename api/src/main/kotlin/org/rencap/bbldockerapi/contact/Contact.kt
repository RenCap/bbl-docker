package org.rencap.bbldockerapi.contact

import javax.persistence.*

@Entity
@Table(name = "CONTACT")
class Contact(
        @Id @GeneratedValue var id: Long? = null,
        @Column(name = "FIRSTNAME") var firstName: String,
        @Column(name = "LASTNAME") var lastName: String,
        @Column(name = "EMAIL") var email: String
)

class ContactDto(
        val id: Long? = null,
        val firstName: String,
        val lastName: String,
        val email: String
)