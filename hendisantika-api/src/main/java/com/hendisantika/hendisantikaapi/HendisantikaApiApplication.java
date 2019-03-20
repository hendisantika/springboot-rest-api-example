package com.hendisantika.hendisantikaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@SpringBootApplication
@EntityScan(basePackageClasses = {HendisantikaApiApplication.class, Jsr310JpaConverters.class})
public class HendisantikaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HendisantikaApiApplication.class, args);
    }

}
