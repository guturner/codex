package io.guy.home.codex.api.common.response

import io.guy.home.codex.api.common.response.models.CodexErrorResponse
import io.guy.home.codex.api.common.response.models.CodexFailureResponse
import io.guy.home.codex.api.common.response.models.CodexSuccessResponse

fun success(data: Any): CodexSuccessResponse = CodexSuccessResponse(data)

fun failure(invalidFields: Map<String, String>, message: String): CodexFailureResponse = CodexFailureResponse(invalidFields, message)

fun error(message: String): CodexErrorResponse = CodexErrorResponse(message)