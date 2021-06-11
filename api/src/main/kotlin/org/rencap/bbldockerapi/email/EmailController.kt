package org.rencap.bbldockerapi.email

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("emails")
@CrossOrigin
class EmailController(private val emailService: EmailService) {

    @PostMapping
    fun sendEmail(@RequestBody emailDto: EmailDto) {
        emailService.sendEmail(emailDto)
    }
}