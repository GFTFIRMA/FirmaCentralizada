angular.module('frontendServices', [])
    .service('ConfigService', ['$http', '$q', function($http, $q) {
        return {
            getFlows: function() {
                var deferred = $q.defer();

                $http.get('ws/flow')
	                .then(function (response) {
	                    if (response.status == 200) {
	                        deferred.resolve(response.data);
	                    }
	                    else {
	                        deferred.reject('Error retrieving list of flows');
	                    }
	                }
	            );

                return deferred.promise;
            }, 
	        getStatus: function() {
	            var deferred = $q.defer();
	
	            $http.get('ws/status')
	                .then(function (response) {
	                    if (response.status == 200) {
	                        deferred.resolve(response.data);
	                    }
	                    else {
	                        deferred.reject('Error retrieving list of status');
	                    }
	                }
	            );
	
	            return deferred.promise;
	        },
	        getResultCodes: function() {
	            var deferred = $q.defer();
	
	            $http.get('ws/result')
	                .then(function (response) {
	                    if (response.status == 200) {
	                        deferred.resolve(response.data);
	                    }
	                    else {
	                        deferred.reject('Error retrieving list of result codes');
	                    }
	                }
	            );
	
	            return deferred.promise;
	        },
	        getInputChannels: function() {
	            var deferred = $q.defer();
	
	            $http.get('ws/inputChannel')
	                .then(function (response) {
	                    if (response.status == 200) {
	                        deferred.resolve(response.data);
	                    }
	                    else {
	                        deferred.reject('Error retrieving list of input Channels');
	                    }
	                }
	            );
	
	            return deferred.promise;
	        }
        
        };
    }]);