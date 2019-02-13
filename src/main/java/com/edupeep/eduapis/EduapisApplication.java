package com.edupeep.eduapis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.edupeep.eduapis.property.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
	FileStorageProperties.class
})
public class EduapisApplication {

	public static void main(String[] args) {
		SpringApplication.run(EduapisApplication.class, args);
	}

}

