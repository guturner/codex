package com.codex.codexpage.mappers

import com.codex.codexpage.dtos.CreateCodexPageResponse
import com.codex.codexpage.entities.CodexPage

fun CodexPage.asCreateCodexPageResponse(): CreateCodexPageResponse {
    return CreateCodexPageResponse(
            pageId = this.pageId,
            title = this.title
    )
}