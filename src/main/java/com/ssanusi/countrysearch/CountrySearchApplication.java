package com.ssanusi.countrysearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountrySearchApplication {

	static CountryList worldCountryList;

	public static void main(String[] args) {
		worldCountryList = new CountryList();
		SpringApplication.run(CountrySearchApplication.class, args);
	}

}
