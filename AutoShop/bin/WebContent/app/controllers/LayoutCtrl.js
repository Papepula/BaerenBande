app.controller('LayoutCtrl', function($scope, CartService) {
		
	$scope.numberItemsCart = function(){	
		return CartService.getCart().length;
	}
	
});