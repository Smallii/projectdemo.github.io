/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var app = angular.module('myApp', ['ngRoute']);

app.config(['$routeProvider', function ($routeProvider) {
        
    $routeProvider.when('/2', {//'/2'定义的路由路径，以后通过此路径访问，通常定义为短路径
        templateUrl: "/welcome.ftl",//"/home/index2"是路由实际访问的路径，可以是asp.net mvc的访问路径（如此例），也可是具体的页面路径，如“test/test.html"
        controller:'UserController'//路由跳转的controller,后面必须定义此控制器
    });

    $routeProvider.when('/3', {
        templateUrl: "/test.ftl",
        controller:'NavigationController'
    });

}]);
