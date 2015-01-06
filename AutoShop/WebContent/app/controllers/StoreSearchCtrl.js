app.controller('StoreSearchCtrl', function($scope, $location, SearchResultService, StoreSearchService) {

	//$scope.numberHits = 5;
	$scope.searchCar = function(searchText) {
		console.log(searchText);
		$scope.text = SearchResultService.getCars(searchText, function(found_hits){
			StoreSearchService.setHits(found_hits);
			//console.log($scope.searchText);
			$location.path('/search/' + searchText);
		});
		/*	StoreSearchService.setHits(found_hits);
			//console.log($scope.searchText);
			$location.path('/search/' + searchText);*/
			
		
		
	}
	//$scope.hits = found_hits;
	//$scope.hits = SearchResultService.getCars($scope.searchText);
	/*SearchResultService.getCars(searchString, function(data) {
		//Hits from DB
		$scope.data
		$scope.numberHits = data.length;
	});*/
	
});