package org.example

import com.sun.net.httpserver.HttpExchange
import org.example.service.GreetingService
import org.koin.mp.KoinPlatform.getKoin

class Router {
    val koin = getKoin()
    val greetingService = koin.get<GreetingService>()
    fun handle(exchange: HttpExchange): Unit {
        val response = greetingService.getGreeting()
        exchange.sendResponseHeaders(200, response.toByteArray().size.toLong())
        exchange.responseBody.use { it.write(response.toByteArray()) }
    }
}