package com.dio.ponto.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket apiAdmin() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dio.ponto"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .apiInfo(apiInfo());
//                .globalOperationParameters(
//                        Collections.singletonList(
//                                new ParameterBuilder()
//                                .name("Authorization")
//                                .description("Header para Token JWT")
//                                .modelRef(new ModelRef("string"))
//                                .parameterType("header")
//                                .required(false)
//                                .build()
//                        )
//                );
    }

//    @Bean
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("Bootcamp Santander da DIO")
//                .description("API para gerenciamento de ponto e acesso")
//                .version("1.0.0")
//                .license("Apache License Version 2.0")
//                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
//                .contact(new Contact("DIO", "https://web.digitalinnovation.one", "contato@digitalinnovationone.com.br"))
//                .build();
//    }

    // @Bean
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Bootcamp Santander da DIO",
                "API para gerenciamento de ponto e acesso",
                "1.0.0",
                "Terms of service",
                new Contact("DIO", "https://web.digitalinnovation.one", "contato@digitalinnovationone.com.br"),
                "Apache License Version 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<VendorExtension>()
        );
    }
}
