package com.project.employeemanagementapi;

import java.util.Collections;
import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringBootEmployeeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmployeeManagementApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.project.employeemanagementapi.controller"))
				.paths(PathSelectors.ant("/api/**")).build().apiInfo(apiDetails());
	}

	private ApiInfo apiDetails()
	{
	//	return new ApiInfo("Employee Management API", "Sample Api for employee management","1.0","Free to Use",new springfox.documentation.service.Contact("Swati Verma","http://localhost:8080/authenticate", "write2swativerma@gmail.com"),"Api License","http://localhost:8080/authenticate",Collections.emptyList());
		return new ApiInfo("Employee Management API", "Sample Api for employee management", "1.0", "Free to Use", "", "","");
	}
}