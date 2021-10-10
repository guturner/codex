package com.codex.infrastructures.mongodb.exceptions

class MongoReadException(override val message: String): Exception(message) {
}