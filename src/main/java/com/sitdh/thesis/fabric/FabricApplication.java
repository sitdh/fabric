package com.sitdh.thesis.fabric;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableAutoConfiguration
@Import(value={FabricAppConfiguration.class, FirebaseAdminConfiguration.class})
public class FabricApplication {

	public static void main(String[] args) {
		SpringApplication.run(FabricApplication.class, args);
	}
}
