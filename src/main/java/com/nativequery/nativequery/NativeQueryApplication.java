package com.nativequery.nativequery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAsync
public class NativeQueryApplication {

	public static void main(String[] args) {
		SpringApplication.run(NativeQueryApplication.class, args);
	}

}
