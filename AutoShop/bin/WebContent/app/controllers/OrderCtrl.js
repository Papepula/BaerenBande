app.controller('OrderCtrl', function($scope, OrderService) {

	$scope.$on('$viewContentLoaded', function () {
		$scope.test = OrderService.saveCart();
	});
});