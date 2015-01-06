app.service('StoreSearchService', function ($http, $q) {

	var hits = {};
	return {
		
		getHits : function(callback) {
			callback(hits);
			return hits;
		},
		
		setHits : function(hit) {
			hits = hit;
			console.log(hits);
		}
	}

});