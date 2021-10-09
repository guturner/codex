package com.codex.codexpage.usecases.create

import com.codex.codexpage.entities.CodexPage

interface CreateCodexPageUseCase {

    fun createCodexPage(title: String): CodexPage
}