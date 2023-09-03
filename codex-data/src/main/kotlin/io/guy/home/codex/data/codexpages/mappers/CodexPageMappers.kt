package io.guy.home.codex.data.codexpages.mappers

import io.guy.home.codex.data.codexpages.models.CodexPageModel
import io.guy.home.codex.domain.codexpages.entities.CodexPage
import java.util.*

fun CodexPageModel.toCodexPage(): CodexPage {
    return CodexPage(
        codexPageId = UUID.fromString(this.codexPageId),
        title = this.title)
}

fun CodexPage.toCodexPageModel(): CodexPageModel {
    return CodexPageModel(
        codexPageId = this.codexPageId.toString(),
        title = this.title)
}