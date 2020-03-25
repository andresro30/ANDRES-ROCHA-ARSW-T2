package edu.eci.arsw.parcial.services;
import edu.eci.arsw.parcial.model.Country;
import edu.eci.arsw.parcial.model.Provincia;

import java.util.List;

public interface CoronavirusServices {

    List<Provincia> getCasesByCountry(String name);
    List<Country>  getAllCases();
}
