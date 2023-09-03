package io.guy.home.codex.domain.codexpages.usecases

import io.guy.home.codex.domain.codexpages.entities.CodexPage
import io.guy.home.codex.domain.codexpages.repositories.CodexPageRepository
import java.util.*

class CreateCodexPageUseCase(
    private val codexPageRepository: CodexPageRepository) {

    fun createCodexPage(title: String): CodexPage {
        val codexPage = CodexPage(
            codexPageId = UUID.randomUUID(),
            title = title)

        return codexPageRepository.saveCodexPage(codexPage)
    }
}