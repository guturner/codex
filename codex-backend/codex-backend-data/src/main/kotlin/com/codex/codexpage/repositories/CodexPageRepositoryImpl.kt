package com.codex.codexpage.repositories

import com.codex.codexpage.entities.CodexPage
import com.codex.codexpage.mappers.asCodexPage
import com.codex.codexpage.mappers.asCodexPageModel
import com.codex.codexpage.models.CodexPageModel
import com.codex.infrastructures.mongodb.kmongo.KMongoRepository
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import org.litote.kmongo.getCollection

class CodexPageRepositoryImpl(client: MongoClient) : KMongoRepository<CodexPageModel>(), CodexPageRepository {

    override lateinit var collection: MongoCollection<CodexPageModel>

    init {
        val database = client.getDatabase("codexdb")
        collection = database.getCollection<CodexPageModel>("codexpages")
    }

    override fun save(codexPage: CodexPage): CodexPage {
        val codexPageModel = codexPage.asCodexPageModel()
        val savedCodexPageModel: CodexPageModel = save(codexPageModel)

        return savedCodexPageModel.asCodexPage()
    }

    override fun getCodexPageByPageId(pageId: String): CodexPage {
        val foundCodexPageModel = getById(pageId)

        return foundCodexPageModel.asCodexPage()
    }
}