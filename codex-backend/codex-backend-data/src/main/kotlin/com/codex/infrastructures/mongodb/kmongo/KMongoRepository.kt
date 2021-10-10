package com.codex.infrastructures.mongodb.kmongo

import com.codex.models.CodexModel
import com.codex.infrastructures.mongodb.MongoRepository
import com.codex.infrastructures.mongodb.exceptions.*
import com.mongodb.client.MongoCollection
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.updateOne

abstract class KMongoRepository<T> : MongoRepository<T> {

    abstract var collection: MongoCollection<T>

    override fun getById(id: String): T {
        return try {
            collection.findOne(CodexModel::id eq id)
                    ?: throw MongoDocumentNotFoundException("No document associated with id: $id.")
        } catch(t: Throwable) {
            throw MongoReadException("Failed to read from the database.")
        }
    }

    override fun getAll(): List<T> {
        return try {
            val result = collection.find()
            result.asIterable().map { it }
        } catch(t: Throwable) {
            throw MongoReadException("Failed to read from the database.")
        }
    }

    override fun save(document: T): T {
        return try {
            collection.insertOne(document)
            document
        } catch(t: Throwable) {
            throw MongoSaveException("Failed to save document: $document to database.")
        }
    }

    override fun update(model: CodexModel): T {
        return try {
            collection.updateOne(
                    CodexModel::id eq model.id,
                    model
            )
            collection.findOne(CodexModel::id eq model.id)
                    ?: throw MongoUpdateException("Failed to update document: $model.")
        } catch(t: Throwable) {
            throw MongoUpdateException("Failed to update document: $model.")
        }
    }

    override fun deleteById(id: String): Boolean {
        return try {
            collection.findOneAndDelete(CodexModel::id eq id)
                    ?: throw MongoDeleteException("Failed to delete document associated with id: $id.")
            true
        } catch (t: Throwable) {
            throw MongoDeleteException("Failed to delete document associated with id: $id.")
        }
    }
}