/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
angular.module('ngRouteExample', ['ngRoute'])

.controller('HomeController', function ($scope, $route) { $scope.$route = $route;})
.controller('AboutController', function ($scope, $route) { $scope.$route = $route;})
.config(function ($routeProvider) {
    $routeProvider.
    when('/home', {
        templateUrl: '/embedded.home.ftl',
        controller: 'HomeController'
    }).
    when('/about', {
        templateUrl: '/embedded.about.ftl',
        controller: 'AboutController'
    }).
    otherwise({
        redirectTo: '/home'
    });
});

