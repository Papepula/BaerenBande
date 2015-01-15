app.controller('SearchResultCtrl', function($scope, $location, SearchResultService) {

	$scope.numberHits = 5;
	
	$scope.searchCar = function() {
		console.log($scope.searchText);
		$location.path('/search/' + $scope.searchText);
	}
	$scope.hits = SearchResultService.getCars();
	/*SearchResultService.getCars(searchString, function(data) {
		//Hits from DB
		$scope.data
		$scope.numberHits = data.length;
	});*/
	
});