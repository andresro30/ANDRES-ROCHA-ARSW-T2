package edu.eci.arsw.parcial.cache.imp;

import edu.eci.arsw.parcial.cache.CoronavirusCache;
import edu.eci.arsw.parcial.model.Provincia;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class CoronavirusCacheImp implements CoronavirusCache {

    private ConcurrentHashMap<String,List<Provincia>> casesCache;
    private ConcurrentHashMap<String,LocalDateTime> casesTime;

    public CoronavirusCacheImp(){
        casesCache = new ConcurrentHashMap<>();
        casesTime = new ConcurrentHashMap<>();
    }

    @Override
    public void saveCasesByCountry(String name, List<Provincia> provincias) {
        casesCache.put(name,provincias);
        casesTime.put(name,LocalDateTime.now());
    }

    @Override
    public ConcurrentHashMap<String, List<Provincia>> getCasesCache() {
        return casesCache;
    }

    @Override
    public ConcurrentHashMap<String, LocalDateTime> getCasesTime() {
        return casesTime;
    }

    @Override
    public void deleteCasestByCountry(String name) {
        casesCache.remove(name);
        casesTime.remove(name);
    }
}
