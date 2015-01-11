app.controller('DetailsCtrl', function($scope, $routeParams,DetailsService, SearchResultService) {
	
	$scope.$on('$viewContentLoaded', function () {
		var carID = $routeParams.id;
		var carouselImages = [];
$scope.rate= 2.8;
		$scope.max = 5;
		
		$scope.isReadonly = false;
	
		SearchResultService.getCar(carID, function(data){
			
			//$scope.rate = data.rating;
			delete data["type"];
			$scope.car = data;
		});
		
		
		$scope.hoveringOver = function(value) {
		    $scope.overStar = value;
		    $scope.percent = 100 * (value / $scope.max);
		  };

		$scope.setRating = function() {
		    console.log($(".happy-bear").length);
		    
		    DetailsService.updateRating({ "id" : $scope.car["id"], "rating" : $(".happy-bear").length }, function(data){
		    	$scope.rate=data;
			    $scope.isReadonly = true;
		    });
		    
		};
		
		var count = 0;
		
		jQuery.each($scope.car, function(i, val) {
			if(i == "image" || i == "image2" || i == "image3"){
				carouselImages[i] = val;
				count++;
			}
		});
		
		
		//$scope.myInterval = 3000;
		$scope.images = carouselImages;
		
		//console.log($scope.images);
	});
});