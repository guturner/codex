package io.guy.home.codex.api.codexpages.controllers

import com.mongodb.MongoWriteException
import io.guy.home.codex.api.codexpages.mappers.toCodexPageResponse
import io.guy.home.codex.api.codexpages.models.CreateCodexPageRequest
import io.guy.home.codex.api.codexpages.models.CreateCodexPageResponse
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
            ResponseEntity.notFound().build()
        } else {
            ResponseEntity.ok(
                codexPage.toCodexPageResponse())
        }
    }

    @PostMapping("/api/v1/codexPages")
    fun createCodexPage(@RequestBody createCodexPageRequest: CreateCodexPageRequest): ResponseEntity<Any> {

        return try {
            val codexPage = createCodexPageUseCase.createCodexPage(createCodexPageRequest.title)

            ResponseEntity.status(201).body(
                CreateCodexPageResponse(
                    codexPage = codexPage.toCodexPageResponse()))
        } catch(ex: MongoWriteException) {
            ResponseEntity.status(409).build()
        }
    }
}