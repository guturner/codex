package com.codex.codexpage.repositories

import com.codex.codexpage.entities.CodexPage

interface CodexPageRepository {

    fun save(codexPage: CodexPage): CodexPage

    fun getCodexPageByPageId(pageId: String): CodexPage
}