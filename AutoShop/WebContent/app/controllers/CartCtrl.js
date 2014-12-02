app.controller('CartCtrl', function($scope, CartService, $timeout) {

    $scope.$on('$viewContentLoaded', function () {    	
    	$scope.cart = CartService.getCart();
    	$('#removeItem').hide();
    });
    
    $scope.increaseAmount = function(car){
    	CartService.addCar(car);
    }
    
    $scope.decreaseAmount = function(index){
    	CartService.decreaseAmount(index);
    }
    
    $scope.removeCar = function(index){
    	
    	$scope.alertRemoveCar = CartService.getCar(index);
    	CartService.removeCar(index);
    	
        

        $('#removeItem').fadeIn();

        $timeout(function () {
            $('#removeItem').fadeOut();
        }, 3000);
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