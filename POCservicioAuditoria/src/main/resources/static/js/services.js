var app = angular.module('elements', [ "ngResource" ]);

app.controller('AuditoriaServiceController', [ '$scope', '$http',
                                     
	function($scope, $http) {
		$scope.getFlows = function() {
			$http.get('/flows').success(function(data) {
				$scope.elements = data;
			});
		}
		
		$scope.getResultCodes = function() {
			$http.get('/resultcodes').success(function(data) {
				$scope.elements = data;
			});
		}

		$scope.getInputChannels = function() {
			$http.get('/inputchannels').success(function(data) {
				$scope.elements = data;
			});
		}		
		
		$scope.getOperationStatus = function() {
			$http.get('/status').success(function(data) {
				$scope.elements = data;
			});
		}	
		
		$scope.getComponents = function() {
			$http.get('/components').success(function(data) {
				$scope.elements = data;
			});
		}	
		
		$scope.getLayers = function() {
			$http.get('/layers').success(function(data) {
				$scope.elements = data;
			});
		}
		
		$scope.getExecutionPoints = function() {
			$http.get('/executionpoints').success(function(data) {
				$scope.elements = data;
			});
		}
		
		$scope.getServices = function() {
			$http.post('/services',  $scope.componentId).success(function(data) {
				$scope.services = data;
			});
		}
		
		$scope.getActivityData = function() {
			$http.post('/activitydata',  $scope.GADactivityId).success(function(data) {
				$scope.activity = data;
			});
		}
		
		$scope.getActivities = function() {
			$http.post('/activities',
				{
					activityFilter :
						{
						activityId : $scope.GAactivityId,
						operationId : $scope.GAoperationId,
						flowId : $scope.GAflowId,
						resultCodeId : $scope.GAresultCodeId,
						executionPointId : $scope.GAexecutionPointId,
						trackingId : $scope.GAtrackingId,
						layerId : $scope.GAlayerId,
						componentId : $scope.GAcomponentId,
						serviceId : $scope.GAserviceId,
						statusId : $scope.GAstatusId,
						startTime : $scope.GAstartTime,
						endTime : $scope.GAendTime
						},
					ordinationField : $scope.GAfield,
					ordinationType : $scope.GAtype,
					pagination :
						{
							numPage : $scope.GAnumPag,
							numRegisters : $scope.GAnumRecs
						}
				}
			).success(function(data) {
				$scope.activities = data;
			});
		}
		
		$scope.getOperationData = function() {
			$http.post('/operationdata',
					{
						operation : 
						{
								operationId : $scope.GODoperationId
						},
						ordinationField : $scope.GODfield,
						ordinationType : $scope.GODtype,
						pagination :
						{
							numPage : $scope.GODnumPag,
							numRegisters : $scope.GODnumRecs
						}
					}
				).success(function(data) {
					$scope.GODsearch = data;
				}
			);
		}
		
		$scope.getOperations = function() {
			$http.post('/operations',
					{
						operation : 
						{
							operationId : $scope.GOoperationId,
							flowId : $scope.GOflowId,
							resultCodeId : $scope.GOresultCodeId,
							inputChannel : $scope.GOinputChannel,
							fcId : $scope.GOfcId,
							requestcId : $scope.GOrequestcId,
							sessionId : $scope.GOsessionId,
							statusId : $scope.GOstatusId,
							startTime : $scope.GOstartTime,
							endTime : $scope.GOendTime
						},
						ordinationField : $scope.GOfield,
						ordinationType : $scope.GOtype,
						pagination :
						{
							numPage : $scope.GOnumPag,
							numRegisters : $scope.GOnumRecs
						}
					}
				).success(function(data) {
					$scope.GOsearch = data;
				}
			);
		}
		
		$scope.reset = function() {
			$scope.elements = null;
			$scope.services = null;
			$scope.activity = null;
			$scope.activities = null;
			$scope.GODsearch = null;
			$scope.GOsearch = null;
		}
} ]);