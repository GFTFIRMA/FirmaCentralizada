angular.module('HomeApp')

.factory('filterDataFactory', ['$http', function($http) {

	var filterDataFactory = {};

	filterDataFactory.getFlows = function() {
		return $http.get('ws/flow');
	}
	
	filterDataFactory.getResultCodes = function() {
		return $http.get('ws/result');
	}

	filterDataFactory.getInputChannels = function() {
		return $http.get('ws/inputChannel');
	}		
	
	filterDataFactory.getStatus = function() {
		return $http.get('ws/status');
	}	
	
	filterDataFactory.getExecutionPoints = function() {
		return $http.get('ws/executionPoint');
	}
	
	filterDataFactory.getLayers = function() {
		return $http.get('ws/layer');
	}
	
	filterDataFactory.getComponents = function() {
		return $http.get('ws/component');
	}
	
	return filterDataFactory;
}]);
