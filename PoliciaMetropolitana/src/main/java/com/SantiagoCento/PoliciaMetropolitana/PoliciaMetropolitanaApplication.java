package com.SantiagoCento.PoliciaMetropolitana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class PoliciaMetropolitanaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoliciaMetropolitanaApplication.class, args);
	}

	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
}

