package io.guy.home.codex.api.common.di.spring

import io.guy.home.codex.data.codexpages.repositories.CodexPageRepositoryImpl
import io.guy.home.codex.domain.codexpages.repositories.CodexPageRepository
import io.guy.home.codex.domain.codexpages.usecases.CreateCodexPageUseCase
import io.guy.home.codex.domain.codexpages.usecases.LookupCodexPageUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoTemplate

@Configuration
class SpringDependencyFactory {

    @Bean
    fun wireCodexPageRepository(mongoTemplate: MongoTemplate): CodexPageRepository {
        return CodexPageRepositoryImpl(
            mongoTemplate)
    }

    @Bean
    fun wireCreateCodexPageUseCase(codexPageRepository: CodexPageRepository): CreateCodexPageUseCase {
        return CreateCodexPageUseCase(
            codexPageRepository)
    }

    @Bean
    fun wireLookupCodexPageUseCase(codexPageRepository: CodexPageRepository): LookupCodexPageUseCase {
        return LookupCodexPageUseCase(
            codexPageRepository)
    }
}