package io.guy.home.codex.codexpages.usecases

import io.guy.home.codex.codexpages.entities.CodexPage
import io.guy.home.codex.codexpages.repositories.CodexPageRepository
import java.util.UUID

class LookupCodexPageUseCase(
    private val codexPageRepository: CodexPageRepository) {

    fun lookupCodexPage(codexPageId: UUID): CodexPage? {
        return codexPageRepository.findOneByCodexPageId(codexPageId)
    }
}