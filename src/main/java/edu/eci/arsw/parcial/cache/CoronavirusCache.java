package edu.eci.arsw.parcial.cache;

import edu.eci.arsw.parcial.model.Provincia;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public interface CoronavirusCache {

    void saveCasesByCountry(String name, List<Provincia> provincias);

    ConcurrentHashMap<String,List<Provincia>> getCasesCache();

    ConcurrentHashMap<String, LocalDateTime> getCasesTime();

    void deleteCasestByCountry(String name);
}
