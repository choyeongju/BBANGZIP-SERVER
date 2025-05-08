package org.sopt.auth.security.logsupport;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sopt.auth.exception.AuthConstant;
import org.sopt.code.ErrorCode;
import org.sopt.response.BaseResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@Component
@RequiredArgsConstructor
public class ErrorResponder {

    private final ObjectMapper objectMapper;

    public void write(HttpServletResponse response, ErrorCode errorCode) {
        try {
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding(AuthConstant.CHARACTER_TYPE);
            response.setStatus(errorCode.getHttpStatus().value());

            PrintWriter writer = response.getWriter();
            writer.write(objectMapper.writeValueAsString(BaseResponse.fail(errorCode)));
        } catch (IOException e) {
            log.error("Error writing response: {}", e.getMessage(), e);
        }
    }
}
