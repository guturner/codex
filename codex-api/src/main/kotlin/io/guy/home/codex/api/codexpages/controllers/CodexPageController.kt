package io.guy.home.codex.api.codexpages.controllers

import io.guy.home.codex.api.codexpages.mappers.toCodexPageResponse
import io.guy.home.codex.api.codexpages.models.CreateCodexPageResponse
import io.guy.home.codex.domain.codexpages.usecases.LookupCodexPageUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class CodexPageController(
    private val lookupCodexPageUseCase: LookupCodexPageUseCase) {

    @GetMapping("/api/v1/codexPages/{codexPageId}")
    fun getCodexPageById(@PathVariable codexPageId: UUID): ResponseEntity<Any> {

        val codexPage = lookupCodexPageUseCase.lookupOneCodexPageByCodexPageId(codexPageId)

        return if (codexPage == null) {
            ResponseEntity.notFound().build()
        } else {
            ResponseEntity.ok(
                CreateCodexPageResponse(
                    codexPage = codexPage.toCodexPageResponse()))
        }
    }
}