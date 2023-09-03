package io.guy.home.codex.data.codexpages.models

import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document("codexpages")
data class CodexPageModel(
    @Indexed(unique = true) val codexPageId: String,
    val title: String)
