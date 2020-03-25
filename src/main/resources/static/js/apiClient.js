var apiClient = (function(){

    var getCasesByCountry = (function(name,callback){
        axios({
            method: 'GET',
            url: '/v1/stats/'+name,
        })
            .then(response => callback(response.data))
            .catch(error => console.log(error));
    });

    var getAllCases = (function(callback){
        axios({
            method: 'GET',
            url: '/v1/stats/',
        })
            .then(response => callback(response.data))
            .catch(error => console.log(error));
    });

    return{
        getCasesByCountry: getCasesByCountry,
        getAllCases: getAllCases,
    }
})();