package edu.eci.arsw.parcial.model;

import java.util.List;

public class Country {

    private String name;
    private Integer numberDeaths;
    private Integer numberInfected;
    private Integer numberCured;
    private List<Provincia> provinciaList;

    public Country(String name, Integer numberDeaths, Integer numberInfected, Integer numberCured, List<Provincia> provinciaList){
        this.name = name;
        this.numberDeaths = numberDeaths;
        this.numberInfected = numberInfected;
        this.numberCured = numberCured;
        this.provinciaList = provinciaList;
    }

    public Integer getNumberDeaths() {
        return numberDeaths;
    }

    public void setNumberDeaths(Integer numberDeaths) {
        this.numberDeaths+=numberDeaths;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberInfected() {
        return numberInfected;
    }

    public Integer getNumberCured() {
        return numberCured;
    }

    public void setNumberCured(Integer numberCured) {
        this.numberCured+=numberCured;
    }

    public void setNumberInfected(Integer numberInfected) {
        this.numberInfected+=numberInfected;
    }

    public List<Provincia> getProvinciaList() {
        return provinciaList;
    }

    public void setProvinciaList(List<Provincia> provinciaList) {
        this.provinciaList = provinciaList;
    }
}
