package org.example.dao.table

import org.jetbrains.exposed.dao.id.LongIdTable

object HellosTable : LongIdTable(name = "hellos") {
    val text = varchar("text", 255)
}