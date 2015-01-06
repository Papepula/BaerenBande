app.service('SearchResultService', function ($http, $q) {
	
	var cars = [
              /*  [
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
             	  ]*/
             ];
	
	return {
		
		getCars : function(searchText, onDataLoaded) {
			$http.get('http://localhost:8080/autoshop/api/car/' + searchText)
			/*
			$http({
			    method: 'GET',
			    url: 'http://localhost:8080/autoshop/api/car/' + searchText,
			    })*/
		            .success(function (car) {
		                // succeed
		               // window.location.href = "#/confirm";
		            	var count = 0;
		            	for ( var car_index in car["cars"]){
		            		cars[count] = [];
		            		cars[count].push(car["cars"][car_index]);
		            		if(cars[count].length == 2){
		            			count++;
		            		}
		            	}
		            	onDataLoaded(cars);
		            	console.log(cars);
		                return cars;
		            })
		            .error(function (data) {
		                // failed
		                window.location.href = "#/error";
		            });
			//return cars;
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