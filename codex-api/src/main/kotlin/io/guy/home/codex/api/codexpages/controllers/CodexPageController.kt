package io.guy.home.codex.api.codexpages.controllers

import io.guy.home.codex.api.codexpages.mappers.toCodexPageResponse
import io.guy.home.codex.api.codexpages.models.CreateCodexPageRequest
import io.guy.home.codex.api.common.response.failure
import io.guy.home.codex.api.common.response.success
import io.guy.home.codex.domain.codexpages.usecases.CreateCodexPageUseCase
import io.guy.home.codex.domain.codexpages.usecases.LookupCodexPageUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class CodexPageController(
    private val createCodexPageUseCase: CreateCodexPageUseCase,
    private val lookupCodexPageUseCase: LookupCodexPageUseCase) {

    @GetMapping("/api/v1/codexPages/{codexPageId}")
    fun getCodexPageById(@PathVariable codexPageId: UUID): ResponseEntity<Any> {

        val codexPage = lookupCodexPageUseCase.lookupOneCodexPageByCodexPageId(codexPageId)

        return if (codexPage == null) {
            ResponseEntity.status(404).body(
                failure(mapOf("codexPageId" to codexPageId.toString()), "CodexPage with codexPageId=$codexPageId not found.")
            )
        } else {
            ResponseEntity.status(200).body(
                success(codexPage.toCodexPageResponse())
            )
        }
    }

    @GetMapping("/api/v1/codexPages")
    fun getCodexPages(): ResponseEntity<Any> {

        val codexPages = lookupCodexPageUseCase.lookupAllCodexPages()

        return ResponseEntity.status(200).body(
            success(codexPages)
        )
    }

    @PostMapping("/api/v1/codexPages")
    fun createCodexPage(@RequestBody createCodexPageRequest: CreateCodexPageRequest): ResponseEntity<Any> {
        val codexPage = createCodexPageUseCase.createCodexPage(createCodexPageRequest.title)

        return ResponseEntity.status(201).body(
            success(codexPage.toCodexPageResponse())
        )
    }
}