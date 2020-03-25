package edu.eci.arsw.parcial.cache.imp;

import edu.eci.arsw.parcial.cache.CoronavirusCache;
import edu.eci.arsw.parcial.model.Provincia;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CoronavirusCacheImp implements CoronavirusCache {

    private ConcurrentHashMap<String,List<Provincia>> cacheCountries;
    private ConcurrentHashMap<String,LocalDateTime> cacheTime;

    public CoronavirusCacheImp(){
        cacheCountries = new ConcurrentHashMap<>();
        cacheTime = new ConcurrentHashMap<>();
    }

    @Override
    public void saveCasesByCountry(String name, List<Provincia> provincias) {
        cacheCountries.put(name,provincias);
        cacheTime.put(name,LocalDateTime.now());
    }

    @Override
    public ConcurrentHashMap<String, List<Provincia>> getCacheCountries() {
        return cacheCountries;
    }

    @Override
    public ConcurrentHashMap<String, LocalDateTime> getCacheTime() {
        return cacheTime;
    }

    @Override
    public void deleteCacheByCountry(String name) {
        cacheCountries.remove(name);
        cacheTime.remove(name);
    }

}
