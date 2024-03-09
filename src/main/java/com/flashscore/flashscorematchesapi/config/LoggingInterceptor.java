package com.flashscore.flashscorematchesapi.config;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flashscore.flashscorematchesapi.common.responses.SuccessResponse;
import com.flashscore.flashscorematchesapi.errors.ApplicationException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@AllArgsConstructor
public class LoggingInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);

    @Override
    public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler, @Nullable ModelAndView modelAndView) throws Exception{

        if (response.getStatus() == 200) {
            MDC.put("LogType", "Info");
            SuccessResponse successResponse = new SuccessResponse(
                    "OK",
                    response.getStatus(),
                    request.getMethod(),
                    request.getRequestURI(),
                    LocalDateTime.now()
            );
            logger.info(String.valueOf(successResponse));
        }
    }
}


