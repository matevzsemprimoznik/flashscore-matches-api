package com.flashscore.flashscorematchesapi.common.responses;

import lombok.Data;
import java.time.LocalDateTime;

public record ApiErrorResponse(String guid, String errorCode, String message, Integer statusCode, String statusName,
                               String path, String method, LocalDateTime timestamp) {
}
