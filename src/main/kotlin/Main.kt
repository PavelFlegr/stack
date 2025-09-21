package org.example

import com.sun.net.httpserver.HttpServer
import org.koin.core.context.startKoin
import java.net.InetSocketAddress
import java.util.concurrent.Executors
import org.flywaydb.core.Flyway
import org.koin.java.KoinJavaComponent.getKoin

fun main() {
    startKoin {
        modules(dbModule, appModule)
    }

    val koin = getKoin()
    val flyway = koin.get<Flyway>()
    flyway.migrate()

    val server = HttpServer.create(InetSocketAddress(8080), 0)
    val router = Router()

    server.createContext("/", router::handle)

    server.executor = Executors.newVirtualThreadPerTaskExecutor()
    server.start()
    println("Server běží na http://localhost:8080/")
}