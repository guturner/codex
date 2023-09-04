package io.guy.home.codex.api.common.response.models

import io.guy.home.codex.api.common.response.constants.CodexResponseStatus

class CodexSuccessResponse(data: Any):
    CodexResponse(
        status = CodexResponseStatus.SUCCESS,
        data = data)