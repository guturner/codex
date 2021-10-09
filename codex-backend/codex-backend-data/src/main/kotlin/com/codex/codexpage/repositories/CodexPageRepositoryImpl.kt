package com.codex.codexpage.repositories

import com.codex.codexpage.entities.CodexPage

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