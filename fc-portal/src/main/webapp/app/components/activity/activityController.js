angular.module('ActivityApp')

.controller('ActivityCtrl', ['$scope', 'filterDataFactory', 'activityDataFactory',
  function ( $scope, filterDataFactory, activityDataFactory) {

		  console.log("Activity Controller reporting for duty.");	  
		  
		  $scope.alert = {
		      msg: ''
		   };  
	
		  getFlows();
		  getStatus();
		  getResultCodes();
		  getExecutionPoints();
		  getLayers();
		  getComponents();

		  // Get List of flows
		  function getFlows() {
			  filterDataFactory.getFlows()
			      .success(function (flowList) {
			          $scope.flowList = flowList;
			      })
			      .error(function (error) {
		                $scope.alert.msg = 'Unable to load flow data: ' + error.message;
		          });
		  }
		  
		  // Get List of status
		  function getStatus() {
			  filterDataFactory.getStatus()
			      .success(function (statusList) {
			          $scope.statusList = statusList;
			      })
			      .error(function (error) {
		                $scope.alert.msg = 'Unable to load status data: ' + error.message;
		          });
		  }
		 
		  // Get List of result codes
		  function getResultCodes() {
			  filterDataFactory.getResultCodes()
			      .success(function (resultList) {
			          $scope.resultList = resultList;
			      })	            
			      .error(function (error) {
		                $scope.alert.msg = 'Unable to load result code data: ' + error.message;
		          });
		  }
		  
		  // Get List of executionPoints
		  function getExecutionPoints() {
			  filterDataFactory.getExecutionPoints()
			      .success(function (executionPointList) {
			          $scope.executionPointList = executionPointList;
			      })	            
			      .error(function (error) {
		                $scope.alert.msg = 'Unable to load execution point data: ' + error.message;
		          });
		  }
		  
		  // Get List of layers
		  function getLayers() {
			  filterDataFactory.getLayers()
			      .success(function (layerList) {
			          $scope.layerList = layerList;
			      })	            
			      .error(function (error) {
		                $scope.alert.msg = 'Unable to load layer data: ' + error.message;
		          });
		  }
		  
		  // Get List of components
		  function getComponents() {
			  filterDataFactory.getComponents()
			      .success(function (componentList) {
			          $scope.componentList = componentList;
			      })	            
			      .error(function (error) {
		                $scope.alert.msg = 'Unable to load component data: ' + error.message;
		          });
		  }
	  
//		$scope.getActivityData = function() {
//			activityDataFactory.getActivityData().success(function(data) {
//				$scope.activity = data;
//			});
//		}
//		
//		$scope.getActivities = function() {
//			activityDataFactory.getActivityData().success(function(data) {
//				$scope.activities = data;
//			});
//		}  
	}
]);
