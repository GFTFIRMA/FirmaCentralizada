/**
 * Main AngularJS Web Application
 */
'use strict';

angular.module('fcPortal', [ 'ngRoute', 'ngSanitize', 'ui.select', 'frontendServices'])
/**
 * Configure the Routes
 */
.config(['$routeProvider', function ($routeProvider) {
  $routeProvider
    // Home
    .when("/", {templateUrl: "partials/home.html", controller: "PageCtrl"})
    // Sections
    .when("/audit/operations", {templateUrl: "partials/audit/operations.html", controller: "AuditCtrl"})
    .when("/audit/activity", {templateUrl: "partials/audit/activity.html", controller: "AuditCtrl"})
    .when("/cases", {templateUrl: "partials/cases.html", controller: "CaseCtrl"})
    // else 404
    .otherwise("/404", {templateUrl: "partials/404.html", controller: "PageCtrl"});
}])
/**
 * Controls the Audit Section
 */
.controller('AuditCtrl', ['$scope', 'ConfigService',
  function ( $scope, ConfigService ) {
	
	  console.log("Audit Controller reporting for duty.");	  
	  
	  // Get List of flows
	  $scope.flow = {};
	  ConfigService.getFlows()
	      .then(function (flowList) {
	          $scope.flowList = flowList;
	      });
	  
	  // Get List of status
	  $scope.status = {};
	  ConfigService.getStatus()
	      .then(function (statusList) {
	          $scope.statusList = statusList;
	      });
	 
	  // Get List of result codes
	  $scope.result = {};
	  ConfigService.getResultCodes()
	      .then(function (resultList) {
	          $scope.resultList = resultList;
	      });
	  
	  // Get List of status
	  $scope.inputChannel = {};
	  ConfigService.getInputChannels()
	      .then(function (inputChannelList) {
	          $scope.inputChannelList = inputChannelList;
	      });
  
	}
])
/**
 * Controls the Sign Cases Section
 */
.controller('CaseCtrl', function (/* $scope, $location, $http */) {
  console.log("Sign Case Controller reporting for duty.");
})
/**
 * Controls all other Pages
 */
.controller('PageCtrl', function (/* $scope, $location, $http */) {
  console.log("Page Controller reporting for duty.");
});
