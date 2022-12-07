package cz.hronza.rhrpoceasybe.interceptor;

import cz.hronza.rhrpoceasybe.exception.EasyBeAccesForbiddenException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HandlerInterceptorImpl implements HandlerInterceptor {

    private static final String TOKEN_KEY = "authorization";
    private static final String TOKEN_PREFIX = "Bearer";
    private final String token;

    private final Logger log = LoggerFactory.getLogger(HandlerInterceptorImpl.class);
    public HandlerInterceptorImpl(String token) {
        this.token = token != null ? String.format("%s %s", TOKEN_PREFIX, token) : "";
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String currenBearerToken = request.getHeader(TOKEN_KEY);
        if (!token.equals(currenBearerToken)) {
            throw new EasyBeAccesForbiddenException();
        }
        log.debug("autorization token is ok");
        return true;
    }
}
