angular.module('OperationApp')

.factory('operationDataFactory', ['$http', function($http) {

	var operationDataFactory = {};	
	
//	operationDataFactory.getOperationData = function() {
//		return $http.post('ws/operationData',
//			{
//				operation : 
//				{
//						operationId : $scope.GODoperationId
//				},
//				ordinationField : $scope.GODfield,
//				ordinationType : $scope.GODtype,
//				pagination :
//				{
//					numPage : $scope.GODnumPag,
//					numRegisters : $scope.GODnumRecs
//				}
//			}
//		);
//	};
	
	operationDataFactory.getOperations = function(filter) {
		return $http.post('ws/operations', filter);
	};
	
	return operationDataFactory;
}]);
