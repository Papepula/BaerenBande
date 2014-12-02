app.service('SearchResultService', function ($http, $q) {
	
	var cars = [
                [
                    {
                  	  "id" : 1, "brand" : "BMW", "model" : "M5 Limousine", "state" : "Gebrauchtwagen", "price" : "40.000", "image" : "bmw_m5.jpg" 
                    },
                    {
                  	  "id" : 2, "brand" : "Peugeot", "model" : "306", "state" : "Neuwagen", "price" : "12.000", "image" : "peugeot_307.jpg"
                    },
                    {
                  	  "id" : 3, "brand" : "Audi", "model" : "A3", "state" : "Neuwagen", "price" : "23.000", "image" : "audi_a3.jpg"
                    }
                ],
                [
                 	{
                	  "id" : 4, "brand" : "Ferrari", "model" : "F430", "state" : "Gebrauchtwagen", "price" : "65.000", "image" : "ferrari_f430.jpg"
                    }
             	  ]
             ]
	
	return {
		
		getCars : function() {
			
			
			return cars;
		},
		
		getCar : function(id) {
			var return_value;
			cars.forEach(function(entry){
				entry.forEach(function(entry_entry){
				
					if(entry_entry.id === parseInt(id)){
						return_value = entry_entry;
					}
				});
			});
			
			return return_value;
		}
	}

});