package lt.codeacademy.alis.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * @Author Mindaugas Luobikis
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo(){
        return new ApiInfo("Alis.am.lt API",
                "Fishing licenses LT Government API",
                "1.0",
                "Terms & Conditions",
                new Contact("Mindaugas Luobikis", "www.eserio-zvynas.lt", "m.luobikis@gmail.com"),
                "Alis.am license",
                "SomeOtherURL",
                Collections.emptyList());
    }
}
