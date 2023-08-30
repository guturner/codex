package io.guy.home.codex.api.codexpages.mappers

import io.guy.home.codex.api.codexpages.models.CodexPageResponse
import io.guy.home.codex.domain.codexpages.entities.CodexPage

fun CodexPage.toCodexPageResponse(): CodexPageResponse {
    return CodexPageResponse(
        codexPageId = this.codexPageId.toString(),
        title = this.title)
}