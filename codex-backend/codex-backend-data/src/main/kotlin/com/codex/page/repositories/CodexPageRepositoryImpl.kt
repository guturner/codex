package com.codex.page.repositories

import com.codex.page.entities.CodexPage

class CodexPageRepositoryImpl : CodexPageRepository {

    override fun save(codexPage: CodexPage): CodexPage {
        // TODO: Replace mock
        return codexPage
    }

    override fun getCodexPageByPageId(pageId: String): CodexPage {
        // TODO: Replace mock
        return CodexPage(pageId, "MockTitle")
    }
}