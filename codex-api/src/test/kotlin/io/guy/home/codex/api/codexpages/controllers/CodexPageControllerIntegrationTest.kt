package io.guy.home.codex.api.codexpages.controllers

import io.guy.home.codex.domain.codexpages.entities.CodexPage
import io.guy.home.codex.domain.codexpages.repositories.CodexPageRepository
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.kotlin.eq
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.util.*

@SpringBootTest
@AutoConfigureMockMvc
class CodexPageControllerIntegrationTest {

    @Autowired private lateinit var mockMvc: MockMvc

    @MockBean private lateinit var mockCodexPageRepository: CodexPageRepository

    @Test
    fun testGetCodexPageById_Returns200() {
        // Given
        val codexPageId = UUID.randomUUID()

        val codexPage = CodexPage(
                codexPageId = codexPageId,
                title = "Hello World")

        whenever(this.mockCodexPageRepository.lookupOneCodexPageByCodexPageId(eq(codexPageId))).thenReturn(codexPage)

        // When
        this.mockMvc.perform(get("/api/v1/codexPages/$codexPageId"))
                // Then
                .andExpect(status().isOk)
    }
}