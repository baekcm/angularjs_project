var app = angular.module('todo', []);

app.controller('TodoCtrl', function($scope, $http) {
	
	$scope.emp = [];
	
	_refreshEmpData();
	
	function _refreshCountryData(){ 
        $ http ({
            method : 'GET', 
            url : 'http://localhost/list'
        }).then(function successCallback(response){
            $scope.emp = response.data;
        }, function errorCallback(response){
            console.log(response.statusText); 
        });
    }

	
});