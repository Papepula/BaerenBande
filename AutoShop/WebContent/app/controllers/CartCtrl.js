app.controller('CartCtrl', function($scope, CartService) {

    // apply the remote data to the local scope
    function applyRemoteData(newCar) {
        $scope.cart = newCar;
        console.log($scope.cart);
    }
    // load data
    $scope.$on('$viewContentLoaded', function () {
    	
    	var item1 = {	"id": "1",
						"brand": "BMW",
						"model" : "M3 Limousine",
						"amount": 1,
						"price" : "50000"};
    	
    	
    	var item2 = {	"id": "2",
						"brand": "BMW",
						"model" : "M4 Limousine",
						"amount": 2,
						"price" : "40000"};
		
    	var items = {	"item1" : item1,
    					"item2" : item2};
    	
    	applyRemoteData(items);
    	CartService.addCar(item1);
    	
    	
        //$('#confirm-cart').hide();
    	/*
        BookService.getBooks($routeParams.searchText).then(function (bookz) {
            applyRemoteData(bookz);
        });
        */
    });
    
    $scope.test = function(test){
    	console.log(test);
    }
	
});