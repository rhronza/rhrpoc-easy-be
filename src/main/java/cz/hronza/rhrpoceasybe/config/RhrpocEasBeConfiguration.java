package cz.hronza.rhrpoceasybe.config;

import cz.hronza.rhrpoceasybe.PackageClass;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {PackageClass.class})
public class RhrpocEasBeConfiguration {
}
