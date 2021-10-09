package com.codex.codexpage.controllers

import com.codex.codexpage.dtos.CreateCodexPageRequest
import com.codex.codexpage.entities.CodexPage
import com.codex.codexpage.usecases.create.CreateCodexPageUseCase
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces

@Controller("/api/v1/codexpages")
class CodexPageController(private val createCodexPageUseCase: CreateCodexPageUseCase) {

    @Post
    @Produces(MediaType.APPLICATION_JSON)
    fun createCodexPage(@Body request: CreateCodexPageRequest): CodexPage {
        return createCodexPageUseCase.createCodexPage(request.title)
    }
}