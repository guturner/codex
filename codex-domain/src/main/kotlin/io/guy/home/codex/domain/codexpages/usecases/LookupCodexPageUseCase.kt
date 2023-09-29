package io.guy.home.codex.domain.codexpages.usecases

import io.guy.home.codex.domain.codexpages.entities.CodexPage
import io.guy.home.codex.domain.codexpages.repositories.CodexPageRepository
import java.util.UUID

class LookupCodexPageUseCase(
    private val codexPageRepository: CodexPageRepository) {

    fun lookupOneCodexPageByCodexPageId(codexPageId: UUID): CodexPage? {
        return codexPageRepository.lookupOneCodexPageByCodexPageId(codexPageId)
    }

    fun lookupAllCodexPages(): Sequence<CodexPage> {
        return codexPageRepository.lookupAllCodexPages()
    }
}