app.service('OrderService', function ($http, $q, CartService) {
	
    return({
    	saveCart: saveCart
    });
    
    function saveCart(){
    	
    	var cart = CartService.getCart();
    	
    	if(cart.length < 1){
    		return;
    	}
 
    	var i = 1;
    	
        // writes data in database
        $http.post("api/cart", cart)
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