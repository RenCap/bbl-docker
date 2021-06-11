package org.rencap.bbldockerapi.email

import org.rencap.bbldockerapi.contact.Contact
import org.rencap.bbldockerapi.contact.ContactRepository
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service


@Service
class EmailServiceImpl(
        private val contactRepository: ContactRepository,
        private val mailSender: JavaMailSender) : EmailService {

    override fun sendEmail(emailDto: EmailDto) {
        val contact: Contact = contactRepository.findById(emailDto.contactId).orElseThrow()

        val message = mailSender.createMimeMessage()
        val helper = MimeMessageHelper(message)
        helper.setFrom("me@example.com")
        helper.setTo(contact.email)
        helper.setSubject(emailDto.subject)
        helper.setText(emailDto.message)

        mailSender.send(message)
    }
}

interface EmailService {
    fun sendEmail(emailDto: EmailDto)
}