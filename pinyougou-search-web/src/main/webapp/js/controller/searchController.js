app.controller('searchController',function($scope,searchService){

	//搜索
	$scope.search=function(){
		searchService.search($scope.searchMap).success(
			function(response){
				$scope.resultMap=response;
			}
		);
	}
});
// app.controller('searchController', function ($scope, searchService) {
//     //搜索
//     $scope.search = function () {
//         searchService.search(searchMap).success(
//             function (response) {
//                 $scope.resultMap = response;
//
//             }
//         )
//
//     }
//
// })