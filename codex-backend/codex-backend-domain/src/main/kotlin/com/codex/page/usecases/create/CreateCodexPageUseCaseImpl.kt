package com.codex.page.usecases.create

import com.codex.page.entities.CodexPage
import com.codex.page.repositories.CodexPageRepository
import java.util.*

class CreateCodexPageUseCaseImpl(val codexPageRepository: CodexPageRepository) : CreateCodexPageUseCase {

    override fun createCodexPage(title: String): CodexPage {
        val codexPage = CodexPage(UUID.randomUUID().toString(), title)
        return codexPageRepository.save(codexPage)
    }
}