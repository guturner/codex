package io.guy.home.codex.api.common.di.spring

import io.guy.home.codex.data.codexpages.repositories.CodexPageRepositoryImpl
import io.guy.home.codex.domain.codexpages.repositories.CodexPageRepository
import io.guy.home.codex.domain.codexpages.usecases.LookupCodexPageUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringDependencyFactory {

    @Bean
    fun wireCodexPageRepository(): CodexPageRepository {
        return CodexPageRepositoryImpl()
    }

    @Bean
    fun wireLookupCodexPageUseCase(codexPageRepository: CodexPageRepository): LookupCodexPageUseCase {
        return LookupCodexPageUseCase(
            codexPageRepository)
    }
}