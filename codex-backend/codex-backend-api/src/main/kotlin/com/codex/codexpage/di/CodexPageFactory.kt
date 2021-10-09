package com.codex.codexpage.di

import com.codex.codexpage.repositories.CodexPageRepositoryImpl
import com.codex.codexpage.usecases.create.CreateCodexPageUseCase
import com.codex.codexpage.usecases.create.CreateCodexPageUseCaseImpl
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Factory
class CodexPageFactory {

    @Singleton
    fun getCreateCodexPageUseCase(): CreateCodexPageUseCase {
        val codexPageRepository = CodexPageRepositoryImpl()

        return CreateCodexPageUseCaseImpl(codexPageRepository)
    }
}