app.controller('CartCtrl', function($scope, CartService) {

    $scope.$on('$viewContentLoaded', function () {
    	
    	var item1 = {	"id": "1",
						"brand": "BMW",
						"model" : "M3 Limousine",
						"price" : "50000"};
    	
    	
    	var item2 = {	"id": "2",
						"brand": "BMW",
						"model" : "M4 Limousine",
						"price" : "40000"};
		
    	
    	CartService.addCar(item2);
    	
    	$scope.cart = CartService.getCart();
    });
    
    $scope.increaseAmount = function(car){
    	CartService.addCar(car);
    }
    
    $scope.decreaseAmount = function(index){
    	CartService.decreaseAmount(index);
    }
    
    $scope.removeCar = function(index){
    	CartService.removeCar(index);
    }
    
});