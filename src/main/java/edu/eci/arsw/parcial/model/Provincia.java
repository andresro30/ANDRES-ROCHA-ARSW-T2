package edu.eci.arsw.parcial.model;

import java.time.LocalDate;

public class Provincia {

    private String city;
    private String name;
    private String country;
    private String lastUpdate;
    private String keyId;
    private Integer casesConfirmed;
    private Integer deaths;
    private Integer recovered;

    public Provincia(String city, String name, String country, String lastUpdate, String keyId, Integer casesConfirmed, Integer deaths, Integer recovered){
        this.city = city;
        this.name = name;
        this.country = country;
        this.lastUpdate = lastUpdate;
        this.keyId = keyId;
        this.casesConfirmed = casesConfirmed;
        this.deaths = deaths;
        this.recovered = recovered;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public String getName() {
        return name;
    }

    public Integer getCasesConfirmed() {
        return casesConfirmed;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public void setCasesConfirmed(Integer casesConfirmed) {
        this.casesConfirmed = casesConfirmed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getCity(){
        return city;
    }

}

