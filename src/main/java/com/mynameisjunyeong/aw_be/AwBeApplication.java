package com.mynameisjunyeong.aw_be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AwBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwBeApplication.class, args);
	}

}
