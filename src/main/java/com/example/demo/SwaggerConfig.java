package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;*/
/*
Swagger UI: http://localhost:8080/swagger-ui.html
*/
package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
@Configuration
//@EnableSwagger2
public class SwaggerConfig{





    @Configuration
    @EnableWebMvc

    public class SwaggerConfig implements WebMvcConfigurer {

        @Bean
        public Docket api() {
            return new Docket(DocumentationType.SWAGGER_2).select()
                    .apis(RequestHandlerSelectors.basePackage("com.companyname.app"))
                    .paths(PathSelectors.regex("/.*"))
                    .build().apiInfo(apiInfoMetaData());
        }

        private ApiInfo apiInfoMetaData() {

            return new ApiInfoBuilder().title("NAME OF SERVICE")
                    .description("API Endpoint Decoration")
                    .contact(new Contact("Dev-Team", "https://www.dev-team.com/", "dev-team@gmail.com"))
                    .license("Apache 2.0")
                    .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                    .version("1.0.0")
                    .build();
        }
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("swagger-ui.html")
                    .addResourceLocations("classpath:/META-INF/resources/");

            registry.addResourceHandler("/webjars/**")
                    .addResourceLocations("classpath:/META-INF/resources/webjars/");
        }


    }

   // @Bean
   // public Docket api() {
      //  return new Docket(DocumentationType.SWAGGER_2).select()
         //       .apis(RequestHandlerSelectors
            //            .basePackage("com.example.demo"))
//.paths(PathSelectors.regex("/.*"))
               // .build().apiInfo(apiEndPointsInfo());
   // }

   // private ApiInfo apiEndPointsInfo() {
//return new ApiInfoBuilder().title("Moje pierwsze API")
            //    .version("0.0.1")
             //   .build();
   // }
}

