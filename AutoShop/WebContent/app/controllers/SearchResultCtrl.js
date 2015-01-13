app.controller('SearchResultCtrl', function($scope, $location,$routeParams, SearchResultService, StoreSearchService) {

	$scope.$on('$viewContentLoaded', function () {    	
		$scope.hitError = false;
		$scope.hitSuccess = false;
	});
	
	SearchResultService.getCars($routeParams.searchText, function(hits, numberHits){
	
		if(hits[0].length !== 0){
			$scope.hits = hits;
			$scope.numberHits = numberHits;
			$scope.hitSuccess = true;
			$scope.hitError = false;
		}
		else {
			$scope.hitSuccess = false;
			$scope.hitError = true;
		}
	});
/*	$scope.hits = StoreSearchService.getHits(function(hits, numberHits){
		
		if(hits[0].length !== 0){
			$scope.hits = hits;
			$scope.numberHits = numberHits;
			$scope.hitSuccess = true;
			$scope.hitError = false;
		}
		else {
			$scope.hitSuccess = false;
			$scope.hitError = true;
		}
	}); */
});