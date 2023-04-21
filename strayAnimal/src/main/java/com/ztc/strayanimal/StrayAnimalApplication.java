package com.ztc.strayanimal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ztc.strayanimal.mapper")
public class StrayAnimalApplication {

	public static void main(String[] args) {
		SpringApplication.run(StrayAnimalApplication.class, args);
	}

}
