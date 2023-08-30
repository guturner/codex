package io.guy.home.codex.domain.codexpages.repositories

import io.guy.home.codex.domain.codexpages.entities.CodexPage
import java.util.UUID

interface CodexPageRepository {

    fun lookupOneCodexPageByCodexPageId(codexPageId: UUID): CodexPage?
}