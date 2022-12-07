package cz.hronza.rhrpoceasybe.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class EasyBeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    public static final String X_CORRELATION_ID = "X-Correlation-Id";
    private final Logger log = LoggerFactory.getLogger(EasyBeResponseEntityExceptionHandler.class);

    @ExceptionHandler(EasyBeAccesForbiddenException.class)
    public ResponseEntity<Object> handleEasyBeAccesForbiddenException(EasyBeAccesForbiddenException ex) {
        String xCorrelationIdValue = getValueFromHttpServletRequestHeader(getAttributeFromHttpRequest(), X_CORRELATION_ID);
        log.error("401 UNAUTHORIZED, {}={}", X_CORRELATION_ID, xCorrelationIdValue);
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .contentType(MediaType.APPLICATION_JSON)
                .body("401 UNAUTHORIZED");
    }

    private HttpServletRequest getAttributeFromHttpRequest() {
        //FIXME Null pointers should not be dereferenced!! - vyhazuje SonarLint
        try {
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            return ((ServletRequestAttributes) requestAttributes).getRequest();
        } catch (NullPointerException ex) {
            log.error("Can't obtain HttpServletRequest instance");
            return null;
        }
    }

    private String getValueFromHttpServletRequestHeader(HttpServletRequest httpServletRequest, String key) {
        if (httpServletRequest != null && key != null)
            return httpServletRequest.getHeader(key);
        return null;
    }
}
