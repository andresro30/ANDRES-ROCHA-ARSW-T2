package edu.eci.arsw.parcial.crontoller;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.parcial.model.Provincia;
import edu.eci.arsw.parcial.services.CoronavirusServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

public class CoronavirusController {

    @Autowired
    private CoronavirusServices services;


    @GetMapping("/v1/stats?{name}")
    public ResponseEntity<?> getCasesByCountry(@PathVariable(name = "name")String name) {
        List<Provincia> provincias = null;
        services.getCasesByCountry(name);
        return new ResponseEntity<>(provincias, HttpStatus.ACCEPTED);
    }

    @GetMapping()
    public ResponseEntity<?> getAllCases(){
        List<String> paises = null;
        services.getAllCases();
        return new ResponseEntity<>(paises, HttpStatus.ACCEPTED);
    }
}
