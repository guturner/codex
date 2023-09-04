package io.guy.home.codex.api.common.response.models

import io.guy.home.codex.api.common.response.constants.CodexResponseStatus

class CodexErrorResponse(message: String):
    CodexResponse(
        status = CodexResponseStatus.SUCCESS,
        message = message)