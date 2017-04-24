//Controller Part
app.controller('TodoCtrl', function($scope, $http) {

	$scope.emp = [];
	$scope.empForm = {
	    empno : "",
	    ename : "",
	    job : "",
	    mgr : "",
	    hiredate : "",
	    sal : "",
	    comm : "",
	    deptno : "",
	    // swich : true => add / swich : false => edit
	    swich : true
	};
	
	// Now load the data from server
	_refreshEmpData();
	
	//HTTP POST/PUT methods for add/edit emp
	$scope.submitEmp = function() {
		
	    var method = "";
	    var url = "";
	    if ($scope.empForm.swich) {
	        //Id is absent in form data, it is create new emp operation
	        method = 'POST';
	        url = '/empData';
	    } else {
	        //Id is present in form data, it is edit emp operation
	        method = 'PUT';
	        url = '/empData';
	    }
	    
	    //alert(angular.toJson($scope.empForm));
	    $http({
	        method : method,
	        url : url,
	        data : angular.toJson($scope.empForm),
	        headers : {
	            'Content-Type' : 'application/json'
	        }
	    }).then(_success, _error);
	};
	
	//HTTP DELETE- delete emp by empno
	$scope.deleteEmp = function(emp) {
	    $http({
	        method : 'DELETE',
	        url : '/empData/' + emp.empno
	    }).then(_success, _error);
	};
	
	function _success(response) {
		_refreshEmpData();
	    _clearFormData();
	}
	
	function _error(response) {
	    console.log(response.statusText);
	}
	
	// In case of edit, populate form fields and assign form.empno with empno
	$scope.editEmp = function(emp) {
	    $scope.empForm.empno = emp.empno;
	    $scope.empForm.ename = emp.ename;
	    $scope.empForm.job = emp.job;
	    $scope.empForm.mgr = emp.mgr;
	    $scope.empForm.hiredate = emp.hiredate;
	    $scope.empForm.sal = emp.sal;
	    $scope.empForm.comm = emp.comm;
	    $scope.empForm.deptno = emp.deptno;
	    // edit : swich => false
	    $scope.empForm.swich = false;
	};
	
	$scope.isValid = function(value) {
	    return !value
	};
	
	/* Private Methods */
	// HTTP GET- get all emp collection
	function _refreshEmpData(){
		
	    $http({
	        method : 'GET', 
	        url : '/empData'
	    }).then(function successCallback(response){
	        $scope.emp = response.data;
	    }, function errorCallback(response){
	    	alert("error");
	        console.log(response.statusText); 
	    });
	}
	
	//Clear the form
	function _clearFormData() {
	    $scope.empForm.empno = "";
	    $scope.empForm.ename = "";
	    $scope.empForm.job = "";
	    $scope.empForm.mgr = "";
	    $scope.empForm.hiredate = "";
	    $scope.empForm.sal = "";
	    $scope.empForm.comm = "";
	    $scope.empForm.deptno = "";
	    // clear : swich => true
	    $scope.empForm.swich = true;
	};

});