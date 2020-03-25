var app = (function(){
    var generarFilaCountry = (function(lista){
        $("#tableOne").empty();
        lista.map(function(country){
            var fila = "<tr><td>"+country.name+"</td><td>"+country.deaths+"</td><td>"+country.confirmed+"</td><td>"+country.recovered+"</td></tr>";
            $("#table").append(fila)
        })
        //plotMarkers(lista);
    });

    /*
    var generarFilaProvincia = (function(lista){
        $("#tableTwo").empty();
        lista.map(function(provincia){
            var fila = "<tr><td>"+provincia.name+"</td><td>"+provincia.deaths"</td><td>"+provincia.confirmed+"</td><td>"+provincia.recovered+"</td></tr>";
            $("#table").append(fila)
        })
        //plotMarkers(lista);
     });
     */

    /*
     getCasesByCountry = (function(name){
        apiClient.getCasesByCountry(name,generarFilaProvincia)
     });
    */
     getAllCases = (function(){
        apiClient.getAllCases(generarFilaCountry)
     });

    return{
        getAllCases: getAllCases,
        generarFilaCountry: generarFilaCountry,
        //getCasesByCountry: getCasesByCountry,
    }
})();