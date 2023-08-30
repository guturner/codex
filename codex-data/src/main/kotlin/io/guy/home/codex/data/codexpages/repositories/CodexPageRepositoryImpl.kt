package io.guy.home.codex.data.codexpages.repositories

import io.guy.home.codex.data.codexpages.mappers.toCodexPage
import io.guy.home.codex.data.codexpages.models.CodexPageModel
import io.guy.home.codex.domain.codexpages.entities.CodexPage
import io.guy.home.codex.domain.codexpages.repositories.CodexPageRepository
import java.util.*

class CodexPageRepositoryImpl: CodexPageRepository {

    override fun lookupOneCodexPageByCodexPageId(codexPageId: UUID): CodexPage? {
        // TODO Replace with MongoDB implementation
        return CodexPageModel(
            codexPageId = codexPageId,
            title = "Hello World!").toCodexPage()
    }
}