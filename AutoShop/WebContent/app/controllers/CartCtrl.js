app.controller('CartCtrl', function($scope, CartService) {

    $scope.$on('$viewContentLoaded', function () {    	
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
    
    $scope.addCar = function(car){
    	CartService.addCar(car);
    }
    
    $scope.getPrice = function(){

    		var price = 0;
    		
    		$scope.cart.forEach(function(entry) {
    			price = price + entry.amount * entry.car.price;
    		});
    		
    		return price;
    }
});