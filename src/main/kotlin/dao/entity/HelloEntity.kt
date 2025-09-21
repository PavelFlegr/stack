package org.example.dao.entity

import org.example.dao.table.HellosTable
import org.example.model.Hello
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class HelloEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<HelloEntity>(HellosTable)

    val text by HellosTable.text

    fun toModel() = Hello(id.value, text)
}
