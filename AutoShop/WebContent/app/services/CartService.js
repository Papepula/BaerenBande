app.service('CartService', function ($http, $q) {
	
    var LS_CART = 'BOOKSTORE_LS_CART';
    // load data
    var cart = JSON.parse(localStorage.getItem(LS_CART));
	   
    if (cart === null) {
        cart = [];
    }
    
	return({
		getCart: getCart,
		addCar: addCar,
		removeCar: removeCar,
		updateCart: updateCart
	});
	
	function getCart(){
		
	}
	
	function addCar(car){
		
		var exist = false;
		var cartItem = carToItem(car);
		
		cart.forEach(function(entry) {
		    console.log(entry);
		    if(entry.car.id === car.id){
		    	console.log("blubb");
		    	entry.amount++;
		    	exist = true;
		    }
		});
		
		if(exist == false){
			cart.push(cartItem);
		}
		
		updateCart();
	}
	
	function removeCar(){
		
	}
	
	function carToItem(car){
        return {
            car: car,
            amount: 1
        };
	}
	
	function updateCart(){
		localStorage.setItem(LS_CART, JSON.stringify(cart));
		console.log("updated");
	}
});