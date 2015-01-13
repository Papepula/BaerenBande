app.service('SearchResultService', function ($http, $q) {
	
	
	return {
		
		getCars : function(searchText, onDataLoaded) {
			$http.get('http://localhost:8080/autoshop/api/car/search/' + searchText)
			/*
			$http({
			    method: 'GET',
			    url: 'http://localhost:8080/autoshop/api/car/' + searchText,
			    })*/
		            .success(function (car) {
		                // succeed
		               // window.location.href = "#/confirm";
		            	if(car !== undefined){
			            	var count = 0;
			            	var cars = [];
			            	cars[count] = [];
			            	var car_count = 0;
			            	for ( var car_index in car["cars"]){
			            		car_count++;
			            		cars[count].push(car["cars"][car_index]);
			            		if(cars[count].length == 3){
			            			count++;
			            			cars[count] = [];
			            		}
			            	}
			            	
			            	onDataLoaded(cars, car_count);
			         
			                return cars;
		            	}
		            	else {
		            		onDataLoaded("noHit", null);
		            	}
		            })
		            .error(function (data) {
		                // failed
		                window.location.href = "#/error";
		            });
			//return cars;
		},
		
		getCar : function(id, callback) {
			
			$http.get('http://localhost:8080/autoshop/api/car/getCar/' + id)
			
				.success(function (car) {					
	            	callback(car);
	         
	                return car;
	            })
	            .error(function (data) {
	                // failed
	                window.location.href = "#/error";
	            });
			
		}
	}

});