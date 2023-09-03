package io.guy.home.codex.data.codexpages.repositories

import io.guy.home.codex.data.codexpages.models.CodexPageModel
import io.guy.home.codex.data.common.testcontainers.CodexMongoTest
import io.guy.home.codex.domain.codexpages.entities.CodexPage
import io.guy.home.codex.domain.codexpages.repositories.CodexPageRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.BasicQuery
import java.util.*

class CodexPageRepositoryImplIntegrationTest: CodexMongoTest() {

    private lateinit var mongoTemplate: MongoTemplate
    private lateinit var codexPageRepository: CodexPageRepository

    @BeforeEach
    fun setUp() {
        mongoTemplate = getMongoTemplate()
        codexPageRepository = CodexPageRepositoryImpl(
                mongoTemplate = mongoTemplate)

        mongoTemplate.dropCollection(CodexPageModel::class.java)
    }

    @Test
    fun testSaveCodexPage_HappyPath() {
        // Given
        val codexPageId = UUID.randomUUID()
        val codexPageTitle = "Hello World!"

        val codexPage = CodexPage(
            codexPageId = codexPageId,
            title = codexPageTitle
        )

        // When
        val savedCodexPage = codexPageRepository.saveCodexPage(codexPage)

        val documentCount = mongoTemplate.count(BasicQuery("{}"), CodexPageModel::class.java)
        val actualCodexPage = mongoTemplate.find(BasicQuery("{ codexPageId : \"$codexPageId\" }"), CodexPageModel::class.java)[0]

        // Then
        assertEquals(1, documentCount)

        assertEquals(codexPageId, savedCodexPage.codexPageId)
        assertEquals(codexPageTitle, savedCodexPage.title)

        assertEquals(codexPageId.toString(), actualCodexPage.codexPageId)
        assertEquals(codexPageTitle, actualCodexPage.title)
    }
}