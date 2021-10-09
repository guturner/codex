package com.codex.page.controllers

import com.codex.page.entities.CodexPage
import com.codex.page.repositories.CodexPageRepository
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import java.util.*

@Controller("/api/v1/pages")
class CodexPageController(private val codexPageRepository: CodexPageRepository) {

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    fun getCodexPage(): CodexPage {
        return codexPageRepository.getCodexPageByPageId(UUID.randomUUID().toString())
    }
}