angular.module('OperationApp')

.controller('OperationCtrl', ['$scope', 'operationDataFactory', 'filterDataFactory', 
      function ( $scope, operationDataFactory, filterDataFactory) {

		  console.log("Operation Controller reporting for duty.");	  
		  
		  $scope.alert = {
		      msg: ''
		    };  
  
		  $scope.flow = {};
		  $scope.status = {};
		  $scope.result = {};
		  $scope.inputChannel = {};
		  $scope.time = {};
		  
		  getFlows();
		  getStatus();
		  getResultCodes();
		  getInputChannels();
		  
		  
		  
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
		  
		  
			  // Get List of inputChannels
		  function getInputChannels() {
			  filterDataFactory.getInputChannels()
		  	      .success(function (inputChannelList) {
		  	          $scope.inputChannelList = inputChannelList;
		  	      })	            
			      .error(function (error) {
		                $scope.alert.msg = 'Unable to load input channel data: ' + error.message;
		          });
		  }

		  $scope.getOperations = function getOperations() {
			  
			  var $flowId = null;
			  if (!angular.isUndefined($scope.flow.selected) || $scope.flow.selected != null)
				  $flowId = $scope.flow.selected.id;
			  var $resultId = null;
			  if (!angular.isUndefined($scope.result.selected) || $scope.result.selected != null)
				  $resultId = $scope.result.selected.id;
			  var $inputChannelId = null;
			  if (!angular.isUndefined($scope.inputChannel.selected) || $scope.inputChannel.selected != null)
				  $inputChannelId = $scope.inputChannel.selected.id;
			  var $statusId = null;
			  if (!angular.isUndefined($scope.status.selected) || $scope.status.selected != null)
				  $statusId = $scope.status.selected.id;
			  var $startDate = new Date($scope.time.startTime);
			  var $endDate = new Date($scope.time.endTime);
				  
			  operationDataFactory.getOperations(
					  {
						  operationId : $scope.operationId,
						  flowId : $flowId,
						  resultCodeId : $resultId,
						  inputChannelId : $inputChannelId,
						  statusId : $statusId,
						  fcId : $scope.fcId,
						  requestcId : $scope.requestcId,
						  sessionId : $scope.sessionId,
						  startTime : $startDate,
						  endTime : $endDate
					  }
			  ).success(function(data) {
						$scope.operationSearch = data;
				  })	            
				  .error(function (error) {
			            $scope.alert.msg = 'Unable to retrieve operation data: ' + error.message;
			      });
		  }
		    
	}
]);
