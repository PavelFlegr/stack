package org.example.dao.repository.impl

import org.example.dao.entity.HelloEntity
import org.example.dao.repository.HelloRepository
import org.example.model.Hello
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction

class HelloRepositoryImpl(private val db: Database): HelloRepository {
    override fun getHello(): Hello = transaction(db) {
        HelloEntity.all().first().toModel()
    }
}