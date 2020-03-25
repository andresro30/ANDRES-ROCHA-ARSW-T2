package edu.eci.arsw.parcial.services.imp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.parcial.cache.CoronavirusCache;
import edu.eci.arsw.parcial.model.Country;
import edu.eci.arsw.parcial.model.Provincia;
import edu.eci.arsw.parcial.services.CoronavirusServices;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


@Service
public class CoronavirusServicesImp implements CoronavirusServices {

    @Autowired
    private CoronavirusCache cache;
    private String url;
    private String apiHost;
    private String apiKey;
    private Gson gson;


    public CoronavirusServicesImp(){
        url = "https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country=";
        apiHost = "covid-19-coronavirus-statistics.p.rapidapi.com";
        apiKey = "80100ea453mshcd0d35d8235246bp102f71jsnf315f9368589";
        gson = new GsonBuilder().create();
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
        //List<Provincia> respuesta = getCasesFromCache(responseApi,name);
        //System.out.println(respuesta.get(0).getCity());
        return null;
    }

    @Override
    public List<Country> getAllCases() {
        List<Provincia> countries = null;
        StringBuilder urlApi = new StringBuilder();
        urlApi.append(url);
        HttpResponse<JsonNode> responseApi = null;
        try {
            responseApi = Unirest.get(urlApi.toString())
                    .header("x-rapidapi-host",apiHost)
                    .header("x-rapidapi-key",apiKey)
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        System.out.println(responseApi);


        JSONArray datos = responseApi.getBody().getObject().getJSONObject("data").getJSONArray("covid19Stats");

        //Pasando a Objeto Java
        countries = gson.fromJson(datos.toString(),new TypeToken<List<Provincia>>(){}.getType());
        System.out.println("Pasó a java");
        System.out.println(countries);
        return createListCountries(countries);
    }

    /*
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
    */

    private List<Country> createListCountries(List<Provincia> datos){
        ArrayList<Country> countryList = new ArrayList<>();
        HashMap<String,Country> nameCountry = new HashMap<>();
        HashMap<String,List<Provincia>> countries = new HashMap<>();

        for(Provincia provincia: datos){
            String name = provincia.getCountry();
            //System.out.println(provincia.getCountry()+" "+provincia.getCasesConfirmed()+" "+provincia.getDeaths());
            if(countries.containsKey(name)){
                //cache.getCacheCountries().get(name).add(provincia);
                countries.get(name).add(provincia);
                nameCountry.get(name).setNumberCured(provincia.getRecovered());
                nameCountry.get(name).setNumberDeaths(provincia.getDeaths());
                nameCountry.get(name).setNumberInfected(provincia.getCasesConfirmed());
            }
            else{
                ArrayList<Provincia> temp = new ArrayList<>();
                temp.add(provincia);
                //cache.getCacheCountries().put(name,temp);
                countries.put(name,temp);
                Country country = new Country(name,provincia.getDeaths(),provincia.getCasesConfirmed(),provincia.getRecovered(),temp);
                System.out.println(name);
                nameCountry.put(name,country);
            }
        }
        return countryList;
    }
}
