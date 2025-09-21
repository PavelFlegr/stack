package org.example

import org.example.dao.repository.HelloRepository
import org.example.dao.repository.impl.HelloRepositoryImpl
import org.example.service.GreetingService
import org.example.service.impl.GreetingServiceImpl
import org.koin.dsl.module

val appModule = module {
    single<GreetingService> { GreetingServiceImpl(get()) }
    single<HelloRepository> { HelloRepositoryImpl(get()) }
}