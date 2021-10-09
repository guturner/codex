package com.codex.page.usecases.create

import com.codex.page.entities.CodexPage

interface CreateCodexPageUseCase {

    fun createCodexPage(title: String): CodexPage
}