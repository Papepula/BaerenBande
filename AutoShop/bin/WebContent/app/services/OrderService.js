app.service('OrderService', function ($http, $q, CartService) {
	
    return({
    	saveCart: saveCart
    });
    
    function saveCart(){
    	
    	var cart = CartService.getCart();
    	
    	if(cart.length < 1){
    		return;
    	}
    	
    	// add user to cart
    	var user = {"userName" : "feb@feberston.de"};
    	cart.push(user);
    	
        // posts cart to server
    	$http({
	    method: 'POST',
	    url: 'http://localhost:8080/autoshop/api/cart',
	    data: cart
	    })
            .success(function () {
                // succeed
                window.location.href = "#/confirm";
                CartService.clearCart();
            })
            .error(function (data) {
                // failed
                window.location.href = "#/error";
            });
    	
    }
    
});