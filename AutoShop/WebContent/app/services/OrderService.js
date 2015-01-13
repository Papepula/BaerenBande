app.service('OrderService', function ($http, $q, CartService, $cookieStore) {
	
    return({
    	saveCart: saveCart
    });
    
    function saveCart(){
    	
    	var cart = CartService.getCart();
    	
    	if(cart.length < 1){
    		return;
    	}
    	
    	if($cookieStore.get('loginState') == 'true'){
    		// add user to cart
    		user = {"userName" : $cookieStore.get('email')};
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
    	}else{
    		window.location.href = "#/login";
    	}

    }
    
});