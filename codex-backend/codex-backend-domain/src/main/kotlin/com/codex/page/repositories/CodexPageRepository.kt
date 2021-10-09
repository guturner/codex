package com.codex.page.repositories

import com.codex.page.entities.CodexPage

interface CodexPageRepository {

    fun save(codexPage: CodexPage): CodexPage

    fun getCodexPageByPageId(pageId: String): CodexPage
}