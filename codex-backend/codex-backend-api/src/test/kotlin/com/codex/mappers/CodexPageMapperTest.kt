package com.codex.mappers

import com.codex.codexpage.entities.CodexPage
import com.codex.codexpage.mappers.asCreateCodexPageResponse
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

class CodexPageMapperTest {

    @Test
    fun testAsCreateCodexPageResponse() {
        // Given
        val pageId = UUID.randomUUID().toString()
        val title = "Fake Title"

        val codexPage = CodexPage(
                pageId = pageId,
                title = title
        )

        // When
        val createCodexPageResponse = codexPage.asCreateCodexPageResponse()

        // Then
        assertEquals(pageId, createCodexPageResponse.pageId)
        assertEquals(title, createCodexPageResponse.title)
    }
}