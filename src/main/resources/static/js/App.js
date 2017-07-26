/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var myApp = angular.module('myApp', ['ui.router', 'ngAnimate', 'myApp.controllers', 'myApp.services']);
myApp.controller('TabsCtrl', ['$scope','$state',function($scope, $state, $http) {
//    console.log('init ctrl');
    $scope.currentType = $state.current.name.split('.')[1];
    $scope.changeTab = function(type){
        $scope.currentType = type;
    };
    $scope.Users = {
        phone:"",
        monicker:"",
        password:"",
        code:""
    };
    //验证电话
    $scope.viPhone = function () {
        console.log($scope.Users.phone);
        if($scope.Users.phone === undefined ){
            console.log("false:" + $scope.Users.phone);
            $scope.PhoneVal = false;
        } else if($scope.Users.phone !== ""){
            console.log("true:" + $scope.Users.phone);
            $scope.PhoneVal = true;
        } else {
            console.log("false:" + $scope.Users.phone);
            $scope.PhoneVal = false;
        }
    };
    //验证用户名
    $scope.viMonicker = function (){
        if($scope.Users.monicker === undefined){
            $scope.MonickerVal = false;
        } else if($scope.Users.monicker !== ""){
            $scope.MonickerVal = true;
        } else {
            $scope.MonickerVal = false;
        }
    };
    //验证密码
    $scope.viPassword = function (){
        if($scope.Users.password === undefined){
            $scope.PasswordVal = false;
        } else if($scope.Users.password !== ""){
            $scope.PasswordVal = true;
        } else {
            $scope.PasswordVal = false;
        }
    };
    //验证验证码
//    $scope.viCode = function (){
//        if($scope.Users.code === undefined){
//            $scope.CodeVal = false;
//        } else if($scope.Users.code !== ""){
//            $scope.CodeVal = true;
//        } else {
//            $scope.CodeVal = false;
//        }
//    };
    
    //注册用户
    $scope.Regin = function (){
        //验证输入框
        if($scope.Users.phone === "" || $scope.Users.phone === undefined){
            alert("请输入电话");
            return false;
        };
        if($scope.Users.monicker === "" || $scope.Users.monicker === undefined){
            alert("请输入名字");
            return false;
        };
        if($scope.Users.password === "" || $scope.Users.password === undefined){
            alert("请输入密码");
            return false;
        };
        alert("恭喜");
//        return false;
        //进度条
        NProgress.start();
        $http({
            method: 'POST',
            url: 'http://192.168.1.18:8080/save'
//            data:{
//                phone:$scope.Users.phone,
//                name:$scope.Users.monicker,
//                pwd:$scope.Users.password
//            }
        }).then(function successCallback(response) {
            //结束进度条
            NProgress.done();
            $scope.allButton.status = "Success!";
            $scope.Users.phone = "";
            $scope.Users.monicker = "";
            $scope.Users.password = "";
            $scope.data = response.data;
            console.log("Success...");
        }, function errorCallback(response) {
            //结束进度条
            NProgress.done();
            Messenger().post({
              message: '网络连接有点问题，过会儿再试吧！',
              type: 'error',
              showCloseButton: true
            });
            // 请求失败执行代码
            $scope.allStatus.status = "Fail!";
            console.log("Fail...");
    });
    };
}]).run(['$state', function($state) {
//		$state.go('app.home');
    }]);
myApp.config(function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise("/tab/Page1");
//    console.log('init ctrl');
     

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
            })
            .state('tab.page4', {
                url:'/Page4',
                templateUrl: '/view/Page4.html'
            });
});