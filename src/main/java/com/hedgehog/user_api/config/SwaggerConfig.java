package com.hedgehog.user_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.function.Predicate;

@Configuration
@EnableSwagger2
//@Import(SpringDataRestConfiguration.class)
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .paths(Predicate.not(PathSelectors.regex("/error.*")))

//                .paths(PathSelectors.ant("/user-api"))
                .build()
                .apiInfo(apiInfo())
                ;
    }

//    public Docket api() {
//        // @formatter:off
//        //Register the controllers to swagger
//        //Also it is configuring the Swagger Docket
//        return new Docket(DocumentationType.SWAGGER_2).select()
//                // .apis(RequestHandlerSelectors.any())
//                .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
//                // .paths(PathSelectors.any())
//                // .paths(PathSelectors.ant("/swagger2-demo"))
//                .build();
//        // @formatter:on
//    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "REST API Uer Service",
                "",
                "API 1.0",
                "https://www.linkedin.com/in/andrew-polewoy-51a161226/",
                new Contact("Andrew Polewoy", "www.gotoqa.ru", "andrewpolewoy@gmail.com"),
                "License of API", "http://gotoqa.ru", Collections.emptyList());
    }
}
