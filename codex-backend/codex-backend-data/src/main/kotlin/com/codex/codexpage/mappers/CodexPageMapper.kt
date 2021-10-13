package com.codex.codexpage.mappers

import com.codex.codexpage.entities.CodexPage
import com.codex.codexpage.models.CodexPageModel

fun CodexPage.asCodexPageModel(): CodexPageModel {
    return CodexPageModel(
            id = this.pageId,
            title = this.title
    )
}

fun CodexPageModel.asCodexPage(): CodexPage {
    return CodexPage(
            pageId = this.id,
            title = this.title
    )
}