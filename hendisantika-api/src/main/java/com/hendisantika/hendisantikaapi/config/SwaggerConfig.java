package com.hendisantika.hendisantikaapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rest-api-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-22
 * Time: 06:06
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Hendisantika REST API")
                        .description("Spring Boot REST API Example")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Hendi Santika")
                                .email("hendisantika@gmail.com")));
    }
}
