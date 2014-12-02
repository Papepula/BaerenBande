app.controller('SearchResultCtrl', function($scope, SearchResultService) {

	$scope.numberHits = 5;
	
	$scope.hits = SearchResultService.getCars();
	/*SearchResultService.getCars(searchString, function(data) {
		//Hits from DB
		$scope.data
		$scope.numberHits = data.length;
	});*/
	
});