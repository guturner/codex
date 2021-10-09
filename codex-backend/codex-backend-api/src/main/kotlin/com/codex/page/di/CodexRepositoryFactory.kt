package com.codex.page.di

import com.codex.page.repositories.CodexPageRepository
import com.codex.page.repositories.CodexPageRepositoryImpl
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Factory
class CodexRepositoryFactory {

    @Singleton
    fun getCodexRepository(): CodexPageRepository {
        return CodexPageRepositoryImpl()
    }
}