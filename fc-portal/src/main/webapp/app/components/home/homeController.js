/**
 * Main AngularJS Web Application
 */
'use strict';

angular.module('HomeApp')
/**
 * Configure the Routes
 */
.config(['$routeProvider', function ($routeProvider) {
  $routeProvider
	  // Home
	  .when("/", {templateUrl: "app/components/home/homeView.html", controller: "HomeCtrl"})
	  // Sections
	  .when("/audit/operation", {templateUrl: "app/components/operation/operationView.html", controller: "OperationCtrl"})
	  .when("/audit/activity", {templateUrl: "app/components/activity/activityView.html", controller: "ActivityCtrl"})
	  .when("/case", {templateUrl: "app/components/case/caseView.html", controller: "CaseCtrl"})
	  // else 404
	  .otherwise("/404", {templateUrl: "app/shared/error/404.html", controller: "HomeCtrl"});
}])
/**
 * Controls the Audit Section
 */
.controller('HomeCtrl', ['$scope',
  function ( $scope ) {
	
	  console.log("Audit Controller reporting for duty.");	  
	  
	  // Get List of flows
	  $scope.flow = {};
	  $scope.status = {};
	  $scope.result = {};
	  $scope.inputChannel = {};
  
	}
]);
