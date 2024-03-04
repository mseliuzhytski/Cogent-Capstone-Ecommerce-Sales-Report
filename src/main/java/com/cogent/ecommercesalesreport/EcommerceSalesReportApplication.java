package com.cogent.ecommercesalesreport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EntityScan(
		basePackages = {"com.cogent.ecommerce.model"}
)
@EnableDiscoveryClient
public class EcommerceSalesReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceSalesReportApplication.class, args);
	}

}
