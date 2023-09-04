package io.guy.home.codex.api.common.response.models

import io.guy.home.codex.api.common.response.constants.CodexResponseStatus

abstract class CodexResponse(
    val status: CodexResponseStatus,
    val data: Any? = null,
    val message: String? = null
)