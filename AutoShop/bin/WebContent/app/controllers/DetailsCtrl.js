app.controller('DetailsCtrl', function($scope, $routeParams, SearchResultService) {
	
	$scope.$on('$viewContentLoaded', function () {
		var carID = $routeParams.id;
		var carouselImages = [];
		
		$scope.car = SearchResultService.getCar(carID);
		
		var count = 0;
		
		jQuery.each($scope.car, function(i, val) {
			if(i == "image" || i == "image2" || i == "image3"){
				carouselImages[i] = val;
				count++;
			}
		});
		
		
		//$scope.myInterval = 3000;
		$scope.images = carouselImages;
		
		console.log($scope.images);
	});
});