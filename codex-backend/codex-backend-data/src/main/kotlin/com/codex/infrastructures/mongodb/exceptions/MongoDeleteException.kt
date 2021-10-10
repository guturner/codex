package com.codex.infrastructures.mongodb.exceptions

class MongoDeleteException(override val message: String): Exception(message) {
}