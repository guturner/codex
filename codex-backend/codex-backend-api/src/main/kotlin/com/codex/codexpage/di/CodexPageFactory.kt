package com.codex.codexpage.di

import com.codex.codexpage.repositories.CodexPageRepositoryImpl
import com.codex.codexpage.usecases.create.CreateCodexPageUseCase
import com.codex.codexpage.usecases.create.CreateCodexPageUseCaseImpl
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton
import org.litote.kmongo.KMongo

@Factory
class CodexPageFactory {

    @Singleton
    fun getCreateCodexPageUseCase(): CreateCodexPageUseCase {
        val kMongoClient = KMongo.createClient("mongodb://codex-localadmin-username:codex-localadmin-password@localhost:27017")
        val codexPageRepository = CodexPageRepositoryImpl(kMongoClient)

        return CreateCodexPageUseCaseImpl(codexPageRepository)
    }
}