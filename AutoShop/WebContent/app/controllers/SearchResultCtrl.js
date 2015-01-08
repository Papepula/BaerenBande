app.controller('SearchResultCtrl', function($scope, $location, SearchResultService, StoreSearchService) {

	
	$scope.hits = StoreSearchService.getHits(function(hits, numberHits){
		$scope.hits = hits;
		$scope.numberHits = numberHits;
	}); 
});