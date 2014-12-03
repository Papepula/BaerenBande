app.service('OrderService', function ($http, $q, CartService) {
	
    return({
    	saveCart: saveCart
    });
    
    function saveCart(){
    	
    	var cart = CartService.getCart();
    	
    	if(cart.length < 1){
    		return;
    	}

        // writes data in database
    	$http({
	    method: 'POST',
	    url: 'http://localhost:8080/autoshop/api/cart',
	    data: cart,
	    headers: {
	        'Content-Type': 'application/xml'
	    }})
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