package io.guy.home.codex.codexpages.repositories

import io.guy.home.codex.codexpages.entities.CodexPage
import java.util.UUID

interface CodexPageRepository {

    fun save(codexPage: CodexPage): CodexPage

    fun findOneByCodexPageId(codexPageId: UUID): CodexPage?
}