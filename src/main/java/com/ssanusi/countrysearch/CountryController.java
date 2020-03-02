package com.ssanusi.countrysearch;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
public class CountryController {

    @GetMapping(value = "/names/all", produces = {"application/json"})
    public ResponseEntity<?> getAllCountries() {
        CountrySearchApplication.worldCountryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(CountrySearchApplication.worldCountryList.countryList, HttpStatus.OK);
    }

    @GetMapping(value = "/names/{letter}", produces = {"application/json"})
    public ResponseEntity<?> getCountryByInitial(@PathVariable char letter) {
        ArrayList<Country> countryList = CountrySearchApplication.worldCountryList.findCountries(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        return new ResponseEntity<>(countryList, HttpStatus.OK);
    }
}
