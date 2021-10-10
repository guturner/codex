package com.codex.infrastructures.mongodb

import com.codex.models.CodexModel

interface MongoRepository<T> {

    fun getById(id: String): T
    fun getAll(): List<T>
    fun save(document: T): T
    fun update(model: CodexModel): T
    fun deleteById(id: String): Boolean
}