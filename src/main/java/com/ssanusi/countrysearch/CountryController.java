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

    @GetMapping(value = "/names/start/{letter}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesByInitial(@PathVariable char letter) {
        ArrayList<Country> countryList = CountrySearchApplication.worldCountryList.findCountries(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        return new ResponseEntity<>(countryList, HttpStatus.OK);
    }

    @GetMapping(value = "/names/size/{number}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesByNameLength(@PathVariable int number) {
        ArrayList<Country> countryList = CountrySearchApplication.worldCountryList.findCountries(c -> c.getName().length() >= number);
        countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(countryList, HttpStatus.OK);
    }

    @GetMapping(value = "/population/size/{number}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesByPopulation(@PathVariable int number) {
        ArrayList<Country> countryList = CountrySearchApplication.worldCountryList.findCountries(c -> c.getPopulation() >= number);
        return new ResponseEntity<>(countryList, HttpStatus.OK);
    }

    @GetMapping(value = "/population/min", produces = {"application/json"})
    public ResponseEntity<?> getMinPopulation() {
        return new ResponseEntity<>(CountrySearchApplication.worldCountryList.getMinPopulation(), HttpStatus.OK);
    }

    @GetMapping(value = "/population/max", produces = {"application/json"})
    public ResponseEntity<?> getMaxPopulation() {
        return new ResponseEntity<>(CountrySearchApplication.worldCountryList.getMaxPopulation(), HttpStatus.OK);
    }

    @GetMapping(value = "/population/median", produces = {"application/json"})
    public ResponseEntity<?> getMedianPopulation() {
        return new ResponseEntity<>(CountrySearchApplication.worldCountryList.getMedianPopulation(), HttpStatus.OK);
    }

    @GetMapping(value = "/age/{age}", produces = {"application/json"})
    public ResponseEntity<?> getCountryByAge(@PathVariable int age) {
        ArrayList<Country> countryList = CountrySearchApplication.worldCountryList.findCountries(c -> c.getMedian() >= age);
        return new ResponseEntity<>(countryList, HttpStatus.OK);
    }

    @GetMapping(value = "/age/min", produces = {"application/json"})
    public ResponseEntity<?> getMinAge() {
        return new ResponseEntity<>(CountrySearchApplication.worldCountryList.getMinAge(), HttpStatus.OK);
    }

    @GetMapping(value = "/age/max", produces = {"application/json"})
    public ResponseEntity<?> getMaxAge() {
        return new ResponseEntity<>(CountrySearchApplication.worldCountryList.getMaxAge(), HttpStatus.OK);
    }

    @GetMapping(value = "/age/median", produces = {"application/json"})
    public ResponseEntity<?> getMedianByAge() {
        return new ResponseEntity<>(CountrySearchApplication.worldCountryList.getMedianAge(), HttpStatus.OK);
    }
}
