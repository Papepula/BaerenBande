app.controller('LoginCtrl', function($scope, $rootScope, $cookieStore, $location, LoginService) {
	
	$rootScope.loginState = false;

	if($cookieStore.get('loginState') == 'true'){
		$rootScope.loginState = true;
	}else{
		$rootScope.loginState = false;
	}
	
	$scope.loginMessage = "";
	
	$scope.login = function(){
		LoginService.loginUser($scope.user).then(function(data){

			if(Object.keys(data).length == 2){				
				$scope.loginMessage = "Benutzernamen oder Passwort ist falsch, oder du bist noch nicht registriert.";
			} else {
				$rootScope.loginState = true;
				$cookieStore.put('loginState', 'true');
				$cookieStore.put('nachname', data.nachname);
				$cookieStore.put('vorname', data.vorname);
				$cookieStore.put('email', data.email);
				$location.path('/');
			}
		})
	}
	
	$scope.logout = function(){
		console.log("Logged out");
		$rootScope.loginState = false;
		$cookieStore.remove('nachname');
		$cookieStore.remove('vorname');
		$cookieStore.remove('email');
		$cookieStore.put('loginState', 'false');
	}
	
});