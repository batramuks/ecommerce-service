package com.batra;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.batra"})
public class EcommerceApplication extends SpringBootServletInitializer {
    /***
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        new SpringApplication(EcommerceApplication.class).run(args);
    }

    /***
     *
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(EcommerceApplication.class);
    }


}
