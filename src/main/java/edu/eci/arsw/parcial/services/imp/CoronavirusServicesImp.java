package edu.eci.arsw.parcial.services.imp;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.parcial.cache.CoronavirusCache;
import edu.eci.arsw.parcial.model.Provincia;
import edu.eci.arsw.parcial.services.CoronavirusServices;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;

public class CoronavirusServicesImp implements CoronavirusServices {

    @Autowired
    private CoronavirusCache cache;
    private String url;
    private String apiHost;
    private String apiKey;
    private Gson gson;

    public CoronavirusServicesImp(){
        String url = "https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?contry=text";
        String apiHost = "covid-19-coronavirus-statistics.p.rapidapi.com";
        String apiKey = "80100ea453mshcd0d35d8235246bp102f71jsnf315f9368589";
    }

    @Override
    public List<Provincia> getCasesByCountry(String name) {
        String code = null;
        try {
            code = URLEncoder.encode(name, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        StringBuilder urlApi = new StringBuilder();
        urlApi.append(urlApi+code);

        HttpResponse<String> responseApi = null;
        try {
            responseApi = Unirest.get(urlApi.toString())
                    .header("x-rapidapi-host",apiHost)
                    .header("x-rapidapi-key",apiKey)
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        //Hacer cache
        List<Provincia> respuesta = getCasesFromCache(responseApi,name);
        System.out.println(respuesta.get(0).getCity());
        return respuesta;
    }

    @Override
    public List<String> getAllCases() {
        List<String> paises = null;
        return paises;
    }

    public List<Provincia> getCasesFromCache(HttpResponse<String> responseApi,String name) {
        List<Provincia> respuesta = null;
        if (cache.getCasesCache().contains(name)) {
            LocalDateTime tiempoActual = LocalDateTime.now();
            LocalDateTime tiempoConsulta = cache.getCasesTime().get("name");
            if (tiempoActual.isAfter(tiempoConsulta.plusMinutes(5))) {
                System.out.println("La petición excedió los 5 minutos");
                cache.deleteCasestByCountry(name);
                respuesta = gson.fromJson(responseApi.getBody(), new TypeToken<List<Provincia>>() {}.getType());
            } else {
                System.out.println("La petición está en cache");
                respuesta = cache.getCasesCache().get(name);
            }
        } else {
            System.out.println("La petición no está en cache");
            respuesta = gson.fromJson(responseApi.getBody(), new TypeToken<List<Provincia>>() {}.getType());
            cache.saveCasesByCountry(name, respuesta);
        }
        return respuesta;

    }
}
