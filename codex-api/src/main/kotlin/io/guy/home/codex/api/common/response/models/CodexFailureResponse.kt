package io.guy.home.codex.api.common.response.models

import io.guy.home.codex.api.common.response.constants.CodexResponseStatus

class CodexFailureResponse(data: Any, message: String):
    CodexResponse(
        status = CodexResponseStatus.FAILURE,
        data = data,
        message = message)