package io.guy.home.codex.api.common.di.spring

import io.guy.home.codex.data.codexpages.repositories.CodexPageRepositoryImpl
import io.guy.home.codex.domain.codexpages.repositories.CodexPageRepository
import io.guy.home.codex.domain.codexpages.usecases.CreateCodexPageUseCase
import io.guy.home.codex.domain.codexpages.usecases.LookupCodexPageUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

@Configuration
class SpringDependencyFactory {

    @Bean
    fun wireCorsFilter(): CorsFilter {
        val source = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration()

        config.allowedOrigins = listOf("http://localhost:3000")
        config.allowedMethods = listOf("DELETE", "GET", "OPTIONS", "PATCH", "POST", "PUT")

        source.registerCorsConfiguration("/**", config)

        return CorsFilter(source)
    }

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