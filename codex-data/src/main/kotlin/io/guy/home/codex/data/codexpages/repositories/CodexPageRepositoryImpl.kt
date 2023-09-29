package io.guy.home.codex.data.codexpages.repositories

import io.guy.home.codex.data.codexpages.mappers.toCodexPage
import io.guy.home.codex.data.codexpages.mappers.toCodexPageModel
import io.guy.home.codex.data.codexpages.models.CodexPageModel
import io.guy.home.codex.data.common.repositories.MongoRepository
import io.guy.home.codex.domain.codexpages.entities.CodexPage
import io.guy.home.codex.domain.codexpages.repositories.CodexPageRepository
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.findAll
import org.springframework.data.mongodb.core.findOne
import org.springframework.data.mongodb.core.query.BasicQuery
import java.util.*

class CodexPageRepositoryImpl(
    private val mongoTemplate: MongoTemplate): MongoRepository<CodexPageModel>(mongoTemplate), CodexPageRepository {

    override fun lookupOneCodexPageByCodexPageId(codexPageId: UUID): CodexPage? {
        val query = BasicQuery("{ codexPageId : \"$codexPageId\" }")

        return mongoTemplate.findOne<CodexPageModel>(query)?.toCodexPage()
    }

    override fun lookupAllCodexPages(): Sequence<CodexPage> {
        return mongoTemplate.findAll<CodexPageModel>().asSequence().map { it.toCodexPage() }
    }

    override fun saveCodexPage(codexPage: CodexPage): CodexPage {
        return save(codexPage.toCodexPageModel()).toCodexPage()
    }
}