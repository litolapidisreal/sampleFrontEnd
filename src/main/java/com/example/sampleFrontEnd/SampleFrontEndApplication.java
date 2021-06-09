package com.example.sampleFrontEnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@SpringBootApplication
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
public class SampleFrontEndApplication {


	public static void main(String[] args) {
		SpringApplication.run(SampleFrontEndApplication.class, args);
	}

//    @Bean
//    public CorsFilter corsFilter(){
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.setAllowCredentials(true);
//        corsConfiguration.setAllowedOrigins(Arrays.asList("http:localhost:4200"));
//        corsConfiguration.setAllowedHeaders(
//                Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-type",
//                        "Accept", "Authorization", "Origin", "Accept", "X-Requested-With",
//                        ));
//
//        );
//    }

}
