'use strict';

angular.module('HomeApp', []);
angular.module('OperationApp', []);
angular.module('ActivityApp', []);
angular.module('CaseApp', []);

// "Main" module and inject all other modules as dependencies 
// to inject all our other modules which in turn allows each of our other modules to access each other.
angular.module('FirmaApp',
  [
    'ngRoute', 
    'ngSanitize',
    'ui.select',
    'HomeApp',
    'OperationApp',
    'ActivityApp',
    'CaseApp',
    'datetimepicker'
  ]
)
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
}]); 