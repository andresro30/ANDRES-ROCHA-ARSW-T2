package edu.eci.arsw.parcial.model;

import java.util.List;

public class Country {

    private String name;
    private int deaths;
    private int confirmed;
    private int recovered;

    public Country(String name, Integer deaths, Integer infected, Integer recovered){
        this.name = name;
        this.deaths = deaths;
        this.confirmed = infected;
        this.recovered = recovered;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths+=deaths;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getConfirmed() {
        return confirmed;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer numberCured) {
        this.recovered+=numberCured;
    }

    public void setConfirmed(Integer numberInfected) {
        this.confirmed+=numberInfected;
    }

}
