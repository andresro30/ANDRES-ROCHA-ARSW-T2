package edu.eci.arsw.parcial.model;

import java.time.LocalDate;

public class Provincia {

    private String city;
    private String province;
    private String country;
    private String lastUpdate;
    private String keyId;
    private int confirmed;
    private int deaths;
    private int recovered;

    public Provincia(String city, String province, String country, String lastUpdate, String keyId, Integer deaths, Integer recovered){
        this.city = city;
        this.province = province;
        this.country = country;
        this.lastUpdate = lastUpdate;
        this.keyId = keyId;
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
        return province;
    }

    public Integer getCasesConfirmed() {
        return confirmed;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public void setCasesConfirmed(Integer casesConfirmed) {
        this.confirmed = casesConfirmed;
    }

    public void setName(String name) {
        this.province = name;
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

