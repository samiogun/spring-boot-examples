package org.ersun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication/*(exclude = SecurityAutoConfiguration.class)*/
public class PostgresqlApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(PostgresqlApplication.class,args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PostgresqlApplication.class);
    }


}
