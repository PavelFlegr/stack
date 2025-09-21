package org.example

import com.sun.net.httpserver.HttpServer
import org.example.service.GreetingService
import org.koin.core.context.startKoin
import org.koin.mp.KoinPlatform.getKoin
import java.net.InetSocketAddress
import java.util.concurrent.Executors

fun main() {
    startKoin {
        modules(appModule)
    }

    val server = HttpServer.create(InetSocketAddress(8080), 0)

    val greetingService = getKoin().get<GreetingService>()

    server.createContext("/") { exchange ->
        val response = greetingService.getGreeting()
        exchange.sendResponseHeaders(200, response.toByteArray().size.toLong())
        exchange.responseBody.use { it.write(response.toByteArray()) }
    }

    server.executor = Executors.newVirtualThreadPerTaskExecutor()
    server.start()
    println("Server běží na http://localhost:8080/")
}