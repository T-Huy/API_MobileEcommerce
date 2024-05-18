package com.ecomerce.android;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.ecomerce.android.config.uploadFile.IStorageService;
import com.ecomerce.android.config.uploadFile.StorageProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class EcomerceAdrBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomerceAdrBeApplication.class, args);
	}

	@Bean
	CommandLineRunner init(IStorageService storageService) {
		return (args -> {
			storageService.init();
		});
	}

}
