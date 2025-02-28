package com.dhs.modeKasu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
@EnableCaching
public class ModeKasuApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModeKasuApplication.class, args);
	}

}
