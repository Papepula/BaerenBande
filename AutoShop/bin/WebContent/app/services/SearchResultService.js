app.service('SearchResultService', function ($http, $q) {
	
	var cars = [
                [
                    {
                  	  "id" : 1, "brand" : "BMW", "model" : "M5 Limousine", "state" : "Gebrauchtwagen", "price" : "40000", "image" : "bmw_m5_1.jpg",
                  	  "image2" : "bmw_m5_2.jpg", "image3" : "bmw_m5_3.jpg"
                    },
                    {
                  	  "id" : 2, "brand" : "Peugeot", "model" : "306", "state" : "Neuwagen", "price" : "12000", "image" : "peugeot_307_1.jpg",
                  	  "image2" : "peugeot_307_2.jpg", "image3" : "peugeot_307_3.jpg"
                    },
                    {
                  	  "id" : 3, "brand" : "Audi", "model" : "A3", "state" : "Neuwagen", "price" : "23000", "image" : "audi_a3_1.jpg",
                  	  "image2" : "audi_a3_2.jpg", "image3" : "audi_a3_3.jpg"
                    }
                ],
                [
                 	{
                	  "id" : 4, "brand" : "Ferrari", "model" : "F430", "state" : "Gebrauchtwagen", "price" : "65000", "image" : "ferrari_f430_1.jpg",
                	  "image2" : "ferrari_f430_2.jpg", "image3" : "ferrari_f430_3.jpg"
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