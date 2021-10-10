package com.codex.codexpage.mappers

import com.codex.codexpage.entities.CodexPage
import com.codex.codexpage.models.CodexPageModel

fun asCodexPageModel(codexPage: CodexPage): CodexPageModel {
    return CodexPageModel(
            id = codexPage.pageId,
            title = codexPage.title
    )
}

fun asCodexPage(codexPageModel: CodexPageModel): CodexPage {
    return CodexPage(
            pageId = codexPageModel.id,
            title = codexPageModel.title
    )
}