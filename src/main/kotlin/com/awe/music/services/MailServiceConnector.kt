package com.awe.music.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class MailServiceConnector @Autowired constructor(val relpyTemplate: KafkaTemplate<String, String>) {
    fun sendRegistrationEmail(email: String) {

    }
}