/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module('myApp.controllers', [])
//获取导航菜单信息
.controller('NavigationCtrl', function($scope, $http){
    console.log("进入");
    $scope.allButton = {
        update:"更新",
        delete:"删除",
        status:""
    };
        //进度条
        NProgress.start();
        //请求数据
    	$http({
        method: 'GET',
        url: 'http://localhost:8080/findAll'
    }).then(function successCallback(response) {
            //结束进度条
            NProgress.done();
            $scope.data = response.data;
            console.log("Success...");
            $scope.allButton.status = "成功";
        }, function errorCallback(response) {
            //结束进度条
            NProgress.done();
            // 请求失败执行代码
            console.log("Fail...");
    });
});