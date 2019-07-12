app.service('searchService',function($http){


	this.search=function(searchMap){
		return $http.post('itemsearch/search.do',searchMap);
	}

});
// app.service('searchService', function ($http) {
//     this.seach = function (searchMap) {
//         return $http.post('itemsearch/search.do', searchMap);
//     }
// });