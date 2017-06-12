/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module('myApp.controllers', [])
.config(function ($routeProvider) {
    $routeProvider.
    when('/home', {
        templateUrl: '/welcome.ftl',
        controller: 'UserController'
    }).
    when('/about', {
        templateUrl: '/test.ftl',
        controller: 'NavigationController'
    }).
    otherwise({
        redirectTo: '/home'
    });
});