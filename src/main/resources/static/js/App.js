/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var myApp = angular.module('myApp', ['ui.router', 'myApp.controllers', 'myApp.services']);
myApp.controller('TabsCtrl', ['$scope','$state',function($scope,$state) {
    console.log('init ctrl');
    $scope.currentType = $state.current.name.split('.')[1];
    $scope.changeTab = function(type){
        $scope.currentType = type;
    };
    $scope.open = function(){
        layer.msg('hello');
    };
}]).run(['$state', function($state) {
//		$state.go('app.home');
    }]);
myApp.config(function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise("/tab/Page1");
    console.log('init ctrl');
     

     $stateProvider
            .state('tab', {
                url:'/tab',
                abstract:true,
                templateUrl:'/view/tabs.html',
                controller:'TabsCtrl'
            })
            .state('tab.page1', {
                url:'/Page1',
                templateUrl: '/view/Page1.html',
                controller:'NavigationCtrl'
            })
            .state('tab.page2', {
                url:'/Page2',
                templateUrl: '/view/Page2.html'
            })
            .state('tab.page3', {
                url:'/Page3',
                templateUrl: '/view/Page3.html'
            });
});