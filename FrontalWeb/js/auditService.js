var auditoriaApp = angular.module('auditoria',[]);

auditoriaApp.controller('AuditController', [ '$scope', '$http', 

	function($scope, $http){
		
		$scope.MostrarDatos($scope, $http) {
			$http.get('/auditoria').success(function() {
				$scope.result = data;
			});
		}
	}
]);