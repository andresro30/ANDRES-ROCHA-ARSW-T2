package edu.eci.arsw.parcial;

import edu.eci.arsw.parcial.services.CoronavirusServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ServiceConfigurationError;

@SpringBootApplication
public class CoronavirusApplication {
    public static void main(String[] args) {
        //Probar conexion http
        SpringApplication.run(CoronavirusApplication.class, args);
    }
}
