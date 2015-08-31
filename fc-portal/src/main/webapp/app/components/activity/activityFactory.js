angular.module('ActivityApp')

.factory('activityDataFactory', ['$http', function($http) {

    var activityDataFactory = {};
    
    activityDataFactory.getActivityData = function () {
        return $http.post('/activitydata',  $scope.GADactivityId);
    };

    activityDataFactory.getActivities = function (id) {
        return $http.post('/activities',
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
					startTimeLocal : $scope.GAstartTime,
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
    	);
    };

    return activityDataFactory;
}]);