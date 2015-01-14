app.controller('RegisterCtrl', function($scope, RegisterService) {
	
	$scope.created = false;
	$scope.registerMessage = "";
	
	$scope.register = function(){
		RegisterService.registerUser($scope.user).then(function(data){

			if(Object.keys(data).length == 2){								
				$scope.registerMessage = "Das Benutzerkonto mit der Email " + $scope.user.email + " ist bereits vorhanden.";
			} else {
				$scope.created = true;
				$scope.user = null;
			}
			
			
		});
	}
	
});