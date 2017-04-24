<!DOCTYPE html>
<html>
  	<head>
	    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
	
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	
		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
		<!-- angularjs 경로 -->
		<script src="js/app.js"></script>
		<script src="js/todoCtrl.js"></script>
  	</head>

  	<body ng-app="todo" ng-controller="TodoCtrl" novalidate>
        <div class="container">
	    	<h1>
	           AngularJS Restful web services example using $http
	        </h1>
        
	        <form name="todoForm" ng-submit="submitEmp()">
	            <table class="table table-bordered">
	                <tr>
	                    <th colspan="2">Add/Edit emp</th>
	                </tr>
	                <tr>
	                    <td>Ename</td>
	                    <td>
	                    	<input type="text" ng-model="empForm.ename" class="form-control" placeholder="Ename input" />
	                    </td>
	                </tr>
	                <tr>
	                    <td>Job</td>
	                    <td>
	                    	<input type="text" ng-model="empForm.job" class="form-control" placeholder="Job input" />
	                    </td>
	                </tr>
	                <tr>
	                    <td>Mgr</td>
	                    <td>
	                    	<div class="form-group" ng-class="{ 'has-error' : todoForm.mgr.$invalid && !todoForm.mgr.$pristine }">
		                    	<input type="text" name="mgr" ng-model="empForm.mgr" class="form-control" placeholder="Mgr input" minlength="4" maxlength="4" ng-pattern="/[0-9]/ " required />
		                    	<!-- 
	                    		<p ng-show="todoForm.mgr.$error.minlength" class="help-block">mgr is too short.</p>
	                    		<p ng-show="todoForm.mgr.$error.pattern" class="help-block">mgr is only number.</p>
	                    		-->
	                    	</div>
	                    </td>
	                </tr>
	                <tr>
	                    <td>Hiredate</td>
	                    <td>
	                    	<input type="text" ng-model="empForm.hiredate" class="form-control" placeholder="Hiredate input" />
	                    </td>
	                </tr>
	                <tr>
	                    <td>Sal</td>
	                    <td>
	                    	<input type="text" ng-model="empForm.sal" class="form-control" placeholder="Sal input" />
	                    </td>
	                </tr>
	                <tr>
	                    <td>Comm</td>
	                    <td>
	                    	<input type="text" ng-model="empForm.comm" class="form-control" placeholder="Comm input" />
	                    </td>
	                </tr>
	                <tr>
	                    <td>Deptno</td>
	                    <td>
	                    	<input type="text" ng-model="empForm.deptno" class="form-control" placeholder="Deptno input" />
	                    </td>
	                </tr>
	                <tr>
	                    <td colspan="2"><input type="submit" value="Write" class="btn btn-primary btn-lg" /></td>
	                </tr>
	            </table>
	        </form>
	        <br />
	        
	        <nav class="navbar navbar-default">
		        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      			<ul class="nav navbar-nav">
	        			<li class="dropdown">
	          				<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">ALL <span class="caret"></span></a>
	        				<ul class="dropdown-menu">
	          					<li><a href="#">ENAME</a></li>
				            	<li role="separator" class="divider"></li>
				            	<li><a href="#">JOB</a></li>
	          				</ul>
	        			</li>
	      			</ul>
	      			<form class="navbar-form navbar-left">
	        			<div class="form-group">
	          				<input type="text" class="form-control" placeholder="Search">
	        			</div>
	        			<button type="submit" class="btn btn-default">Submit</button>
	      			</form>
		  		</div><!-- /.navbar-collapse -->
	  		</nav>
	        
	        <table class="table table-bordered">
	            <tr>
	                <th>Empno</th>
	                <th>Ename</th>
	                <th>Job</th>
	                <th>Mgr</th>
	                <th>Hiredate</th>
	                <th>Sal</th>
	                <th>Comm</th>
	                <th>Deptno</th>
	                <th>Operations</th>
	            </tr>
	            <tr ng-repeat="data in emp | filter : search">
				    <td> {{ data.empno }}</td>
				    <td>{{ data.ename }}</td>
				    <td>{{ data.job }}</td>
				    <td>{{ data.mgr }}</td>
				    <td>{{ data.hiredate.substring(0, 10) }}</td>
				    <td>{{ data.sal }}</td>
				    <td>{{ data.comm }}</td>
				    <td>{{ data.deptno }}</td>
	                <td><a ng-click="editEmp(data)" class="btn btn-success btn-sm">Edit</a> | <a ng-click="deleteEmp(data)" class="btn btn-danger btn-sm">Delete</a></td>
	            </tr>
	        </table>
		</div>
		
  	</body>

</html>