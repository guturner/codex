package io.guy.home.codex.data.codexpages.mappers

import io.guy.home.codex.data.codexpages.models.CodexPageModel
import io.guy.home.codex.domain.codexpages.entities.CodexPage

fun CodexPageModel.toCodexPage(): CodexPage {
    return CodexPage(
        codexPageId = this.codexPageId,
        title = this.title)
}