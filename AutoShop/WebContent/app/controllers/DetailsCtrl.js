app.controller('DetailsCtrl', function($scope, $routeParams, SearchResultService) {
	
	$scope.$on('$viewContentLoaded', function () {
		var carID = $routeParams.id;
		
		$scope.car = SearchResultService.getCar(carID);
	});
});