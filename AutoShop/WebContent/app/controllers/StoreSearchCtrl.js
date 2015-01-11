app.controller('StoreSearchCtrl', function($scope, $location, SearchResultService, StoreSearchService) {

	$scope.searchCar = function(searchText) {
		$scope.text = SearchResultService.getCars(searchText, function(found_hits, numberHits){
			StoreSearchService.setHits(found_hits, numberHits);
			$location.path('/search/' + searchText);
		});	
	}
	
});