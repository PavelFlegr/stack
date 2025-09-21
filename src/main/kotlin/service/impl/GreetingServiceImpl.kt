package org.example.service.impl

import org.example.service.GreetingService

class GreetingServiceImpl: GreetingService {
    override fun getGreeting(): String = "Hello from Loom and Kotlin with Koin!"
}