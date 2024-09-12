package com.ferchauapp.ferchau_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ferchauapp")
public class FerchauAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FerchauAppApplication.class, args);
	}

}
