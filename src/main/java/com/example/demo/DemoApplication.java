package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class DemoApplication {

	@Value("${file.prefix}")
	String prefix;

	@Value("${folder.path.name}")
	String folder;



	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Bean
	public WebMvcConfigurer configurer(){

		return  new WebMvcConfigurer() {
			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				   registry.addResourceHandler("/"+prefix+"/**").addResourceLocations(folder);
			}
		};
	}

}
