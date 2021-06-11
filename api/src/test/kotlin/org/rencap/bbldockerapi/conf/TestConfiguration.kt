package org.rencap.bbldockerapi.conf

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.JavaMailSenderImpl

@Configuration
class TestConfiguration {
    @Bean
    fun javaMailSender(): JavaMailSender {
        return JavaMailSenderImpl()
    }
}