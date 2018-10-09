package com.zzx.config;

/**
 * Created by Mr.John on 2018/10/9 21:30.
 **/

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerConfig
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public static final String VERSION = "0.1.0 a";

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger Server Rest API Document")
                .description("***.***.***")
                .termsOfServiceUrl("")
                .version(VERSION)
                .build();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .build();
    }
}
