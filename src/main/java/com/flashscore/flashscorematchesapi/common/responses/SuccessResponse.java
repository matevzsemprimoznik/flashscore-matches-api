package com.flashscore.flashscorematchesapi.common.responses;

import java.time.LocalDateTime;

public record SuccessResponse (String message, Integer statusCode, String method, String path, LocalDateTime timestamp) {
}

