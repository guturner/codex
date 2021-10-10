package com.codex.infrastructures.mongodb.exceptions

class MongoDocumentNotFoundException(override val message: String): Exception(message) {

}