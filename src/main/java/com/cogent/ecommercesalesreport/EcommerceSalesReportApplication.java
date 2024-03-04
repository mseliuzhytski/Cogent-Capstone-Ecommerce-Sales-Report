package com.cogent.ecommercesalesreport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(
		basePackages = {"com.cogent.ecommerce.model"}
)
public class EcommerceSalesReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceSalesReportApplication.class, args);
	}

}
