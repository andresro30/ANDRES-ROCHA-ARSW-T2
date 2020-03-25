package edu.eci.arsw.parcial.crontoller;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.parcial.model.Country;
import edu.eci.arsw.parcial.model.Provincia;
import edu.eci.arsw.parcial.services.CoronavirusServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1")
public class CoronavirusController {

    @Autowired
    private CoronavirusServices services;


    @GetMapping("/stats/{name}")
    public ResponseEntity<?> getCasesByCountry(@PathVariable(name = "name")String name) {
        try{
            List<Provincia> provincias = null;
            provincias = services.getCasesByCountry(name);
            return new ResponseEntity<>(provincias, HttpStatus.ACCEPTED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("ERROR DE SERVIDOR",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/stats/")
    public ResponseEntity<?> getAllCases(){
        try{
            List<Country> paises = null;
            paises = services.getAllCases();
            System.out.println(paises);
            return new ResponseEntity<>(paises, HttpStatus.ACCEPTED);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("ERROR DE SERVIDOR",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
