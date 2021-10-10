package com.codex.codexpage.usecases.create

import com.codex.codexpage.entities.CodexPage
import com.codex.codexpage.repositories.CodexPageRepository
import java.util.*

class CreateCodexPageUseCaseImpl(private val codexPageRepository: CodexPageRepository) : CreateCodexPageUseCase {

    override fun createCodexPage(title: String): CodexPage {
        val codexPage = CodexPage(UUID.randomUUID().toString(), title)
        return codexPageRepository.save(codexPage)
    }
}