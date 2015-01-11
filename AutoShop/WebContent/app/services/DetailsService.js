app.service('DetailsService', function ($http, $q) {
	
	
	return {
		
		updateRating : function(obj, callback) {
			
			$http.post('http://localhost:8080/autoshop/api/car/updateRating/' + obj["id"] + '/' + obj["rating"])
			
				.success(function (rating) {
					console.log(rating);
					
	            	/*callback(rating);
	         
	                return rating;*/
	            })
	            .error(function (data) {
	                // failed
	                window.location.href = "#/error";
	            });
			
		}
	}

});