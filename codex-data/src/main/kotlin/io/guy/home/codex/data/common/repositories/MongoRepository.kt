package io.guy.home.codex.data.common.repositories

import org.springframework.data.mongodb.core.MongoTemplate

abstract class MongoRepository<T: Any>(
    private val mongoTemplate: MongoTemplate) {

    fun save(document: T): T {
        return mongoTemplate.save(document)
    }
}