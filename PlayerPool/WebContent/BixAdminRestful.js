

function getSkaters($scope, $http)
{
    $http.get('http://abdul:8080/PlayerPoolService/rest/PlayerPoolService/Skaters').
        success(function(data) {
		$scope.skaters = data;
	    });
}

function getRinks($scope, $http)
{
    $http.get('http://abdul:8080/PlayerPoolService/rest/PlayerPoolService/Rinks').
        success(function(data) {
		$scope.rinks = data;
	    });
}

function getRinksJson($scope, $http)
{
    console.log("getRinksJson");

    $http.get('http://abdul:8080/PlayerPoolService/rest/PlayerPoolService/RinkJson').
        success(function(data) {
		$scope.rinks = data;
	    });
}
