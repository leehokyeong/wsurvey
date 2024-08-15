package com.woongjin.pjt.wsurveyapi.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
* Swagger Springdoc-ui 구성 파일
* */
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI(){
        Info info = new Info()
                .title("wsurvey springdoc UI")
                .version("v1.0")
                .description("wsurvey project API 문서");
        return new OpenAPI()
                .info(info)
                .components(new Components());
    }
}
