app.controller('SearchResultCtrl', function($scope, $location, SearchResultService, StoreSearchService) {

	
	$scope.hits = StoreSearchService.getHits(function(hits){
		$scope.hits = hits;
		$scope.numberHits = hits.length;
	}); 
	$scope.numberHits = $scope.hits.length;
	console.log($scope.hits);
});