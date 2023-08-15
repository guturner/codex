package io.guy.home.codex.codexpages.usecases

import io.guy.home.codex.codexpages.entities.CodexPage
import io.guy.home.codex.codexpages.repositories.CodexPageRepository
import java.util.*

class CreateCodexPageUseCase(
    private val codexPageRepository: CodexPageRepository) {

    fun createCodexPage(title: String): CodexPage {
        val newCodexPage = CodexPage(
            codexPageId = UUID.randomUUID(),
            title = title
        )

        return codexPageRepository.save(newCodexPage)
    }
}