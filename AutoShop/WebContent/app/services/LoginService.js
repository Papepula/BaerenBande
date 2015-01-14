app.service('LoginService', function ($http, $q) {
	
	return({
		loginUser: loginUser
	})
	
	function loginUser(user){
		var request = $http({
			method: 'post',
			url: 'http://localhost:8080/autoshop/api/login',
			data: user
		
		});
		return( request.then( handleSuccess, handleError ) );
	}
	

    function handleError(response) {
        if (!angular.isObject(response.data) || !response.data.message) {
            return ($q.reject("An unknown error occurred."));
        }
        return ($q.reject(response.data.message));
    }

    function handleSuccess(response) {
        console.log(response.data);
        return (response.data);
    }

});