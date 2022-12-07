package cz.hronza.rhrpoceasybe.config;

import cz.hronza.rhrpoceasybe.PackageClass;
import cz.hronza.rhrpoceasybe.interceptor.HandlerInterceptorImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackageClasses = {PackageClass.class})
public class RhrpocEasBeConfiguration implements WebMvcConfigurer {

    private final HandlerInterceptorImpl handlerInterceptor;

    public RhrpocEasBeConfiguration(@Value("${token}") String token) {
        handlerInterceptor = new HandlerInterceptorImpl(token);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(handlerInterceptor);
    }
}
