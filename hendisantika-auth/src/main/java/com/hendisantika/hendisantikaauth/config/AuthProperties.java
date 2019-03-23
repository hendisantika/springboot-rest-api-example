package com.hendisantika.hendisantikaauth.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rest-api-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-24
 * Time: 05:50
 */
@Data
@Configuration
@ConfigurationProperties("auth")
public class AuthProperties {

    private String redirectionUrl;

}