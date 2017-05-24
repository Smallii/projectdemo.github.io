var app = angular.module('myApp', ['ionic']);

app.controller('myCtrl', function($scope, $http, $ionicLoading) {
    $scope.allStatus = {
        status:"null!",
        button:"获取数据...",
        save:"Add",
        del:"Del",
        update:"Update"
    },
    $scope.par = {
        id:"",
        name:"",
        pwd:""
    };
    // 等待
	  $ionicLoading.show({
	    content: 'Loading',
	    animation: 'fade-in',
	    showBackdrop: true,
	    maxWidth: 200,
	    showDelay: 0
	  });
    //请求数据
    	$http({
        method: 'GET',
        url: 'http://localhost:8080/findAll'
    }).then(function successCallback(response) {
            $ionicLoading.hide();
            $scope.allStatus.status = "Success!";
            $scope.names = response.data;
            console.log("Success...");
        }, function errorCallback(response) {
            $ionicLoading.hide();
            // 请求失败执行代码
            $scope.allStatus.status = "Fail!";
            console.log("Fail...");
    });

    $scope.save = function(){
        // 等待
	  $ionicLoading.show({
	    content: 'Loading',
	    animation: 'fade-in',
	    showBackdrop: true,
	    maxWidth: 200,
	    showDelay: 0
	  });
        $http({
        method: 'POST',
        url: 'http://localhost:8080/save',
        data:{
            name:$scope.par.name,
            pwd:$scope.par.pwd
        }
    }).then(function successCallback(response) {
            $ionicLoading.hide();
            $scope.allStatus.status = "Success!";
            $scope.par.name = "";
            $scope.par.pwd = "";
            $scope.names = response.data;
            console.log("Success...");
        }, function errorCallback(response) {
            $ionicLoading.hide();
            // 请求失败执行代码
            $scope.allStatus.status = "Fail!";
            console.log("Fail...");
    });
    },
    $scope.del = function(id){
        // 等待
	  $ionicLoading.show({
	    content: 'Loading',
	    animation: 'fade-in',
	    showBackdrop: true,
	    maxWidth: 200,
	    showDelay: 0
	  });
        $http({
        method: 'POST',
        url: 'http://localhost:8080/delete',
        data:{
            id:id
        }
    }).then(function successCallback(response) {
            $ionicLoading.hide();
            $scope.allStatus.status = "Success!";
            $scope.names = response.data;
            console.log("Success...");
        }, function errorCallback(response) {
            $ionicLoading.hide();
            // 请求失败执行代码
            $scope.allStatus.status = "Fail!";
            console.log("Fail...");
    });
    },
    $scope.findById = function(id){
        // 等待
	  $ionicLoading.show({
	    content: 'Loading',
	    animation: 'fade-in',
	    showBackdrop: true,
	    maxWidth: 200,
	    showDelay: 0
	  });
        $http({
        method: 'POST',
        url: 'http://localhost:8080/findById',
        data:{
            id:id
        }
    }).then(function successCallback(response) {
            $ionicLoading.hide();
            $scope.allStatus.status = "Success!";
            $scope.par.name = response.data.name;
            $scope.par.pwd = response.data.pwd;
            $scope.allStatus.save = "Update";
            console.log("Success...");
        }, function errorCallback(response) {
            $ionicLoading.hide();
            // 请求失败执行代码
            $scope.allStatus.status = "Fail!";
            console.log("Fail...");
    });
    };
    
});
