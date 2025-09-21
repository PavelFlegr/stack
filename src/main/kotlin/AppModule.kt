package org.example

import org.example.service.impl.GreetingServiceImpl
import org.koin.dsl.module

val appModule = module {
    single { GreetingServiceImpl() }
}