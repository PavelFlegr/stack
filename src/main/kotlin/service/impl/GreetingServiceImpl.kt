package org.example.service.impl

import org.example.dao.repository.HelloRepository
import org.example.service.GreetingService

class GreetingServiceImpl(
    private val helloRepository: HelloRepository
): GreetingService {
    override fun getGreeting(): String {
        return try {
            helloRepository.getHello().text
        } catch (e: Exception) {
            "Hello, world!"
        }
    }
}