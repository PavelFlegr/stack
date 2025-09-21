package org.example.dao.repository

import org.example.model.Hello

interface HelloRepository {
    fun getHello(): Hello
}