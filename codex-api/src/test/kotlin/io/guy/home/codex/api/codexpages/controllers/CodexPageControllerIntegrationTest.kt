package io.guy.home.codex.api.codexpages.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import io.guy.home.codex.api.codexpages.models.CreateCodexPageRequest
import io.guy.home.codex.domain.codexpages.entities.CodexPage
import io.guy.home.codex.domain.codexpages.repositories.CodexPageRepository
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.eq
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
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
                .andExpect(jsonPath("$.status", equalTo("SUCCESS")))
                .andExpect(jsonPath("$.data.codexPageId", equalTo(codexPageId.toString())))
                .andExpect(jsonPath("$.data.title", equalTo("Hello World")))
    }

    @Test
    fun testGetCodexPageById_Returns404_WhenCodexPageNotFound() {
        // Given
        val codexPageId = UUID.randomUUID()

        whenever(this.mockCodexPageRepository.lookupOneCodexPageByCodexPageId(eq(codexPageId))).thenReturn(null)

        // When
        this.mockMvc.perform(get("/api/v1/codexPages/$codexPageId"))
            // Then
            .andExpect(status().isNotFound)
            .andExpect(jsonPath("$.status", equalTo("FAILURE")))
            .andExpect(jsonPath("$.data.codexPageId", equalTo(codexPageId.toString())))
            .andExpect(jsonPath("$.message", equalTo("CodexPage with codexPageId=$codexPageId not found.")))
    }

    @Test
    fun testCreateCodexPage_Returns201() {
        // Given
        val codexPageId = UUID.randomUUID()

        val createCodexPageRequest = CreateCodexPageRequest(
            title = "Hello World")
        val json = ObjectMapper().writeValueAsString(createCodexPageRequest)

        val codexPage = CodexPage(
            codexPageId = codexPageId,
            title = "Hello World")

        whenever(this.mockCodexPageRepository.saveCodexPage(any())).thenReturn(codexPage)

        // When
        this.mockMvc.perform(
                post("/api/v1/codexPages")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json)
            )
            // Then
            .andExpect(status().isCreated)
            .andExpect(jsonPath("$.status", equalTo("SUCCESS")))
            .andExpect(jsonPath("$.data.codexPageId", equalTo(codexPageId.toString())))
            .andExpect(jsonPath("$.data.title", equalTo("Hello World")))
    }
}