app.service('StoreSearchService', function ($http, $q) {

	var hits = {};
	var numberhits = 0;
	return {
		
		getHits : function(callback) {
			
			callback(hits, numberhits);
			return hits;
		},
		
		setHits : function(hit, numberHits) {
			
			hits = hit;
			numberhits = numberHits;
		}
	}

});