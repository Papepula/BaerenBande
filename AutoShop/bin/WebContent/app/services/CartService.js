app.service('CartService', function ($http, $q) {
	
    var LS_CART = 'BOOKSTORE_LS_CART';
    var cart = JSON.parse(localStorage.getItem(LS_CART));
	   
    if (cart === null) {
        cart = [];
    }
    
	return({
		getCart: getCart,
		addCar: addCar,
		removeCar: removeCar,
		decreaseAmount: decreaseAmount,
		getCar: getCar,
		clearCart: clearCart
	});
	
	function getCart(){		
		return cart;
	}
	
	function addCar(car){
		
		var exist = false;
		var cartItem = carToItem(car);
		
		//if car already exists
		cart.forEach(function(entry) {
		    if(entry.car.id === car.id){
		    	entry.amount++;
		    	exist = true;
		    }
		});
		
		if(exist == false){
			cart.push(cartItem);
		}
	
		updateCart();
	}
	
	function removeCar(index){
		
		cart.splice(index, 1)	
		updateCart();
	}
	
	function decreaseAmount(index){

		cart[index].amount--;
		
        if (cart[index].amount === 0) {
            removeCar(index);
        }
		
		updateCart();
	}
	
	function getCar(index){
		return cart[index];
	}
	
	// creates CartItem
	function carToItem(car){
		
        return {
            car: car,
            amount: 1
        };
	}
	
	// writes cart into localstorage
	function updateCart(){
		localStorage.setItem(LS_CART, JSON.stringify(cart));
	}
	
	// clear localstorage
	function clearCart(){
        localStorage.removeItem(LS_CART);
        cart = [];
	}
	
});