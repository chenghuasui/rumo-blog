package com.rumo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.rumo.mapper")
public class RumoBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(RumoBlogApplication.class, args);
	}
	
}
