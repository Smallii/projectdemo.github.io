/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


angular.module('myApp.controllers', [])
//获取导航菜单信息
.controller('WebSockCtrl', function($scope, $http){
    var stompClient = null;
    $scope.connect = function(){
        if ("WebSocket" in window){
            alert("您的浏览器支持 WebSocket!");
            // 打开一个 web socket
            var ws = new WebSocket("ws://192.168.1.18:8080/gs-guide-websocket");
                ws.onopen = function() {
                // Web Socket 已连接上，使用 send() 方法发送数据
                
                alert("数据发送中...");
            };

            ws.onmessage = function (evt) 
            { 
               $scope.data = evt.data;
               alert("数据已接收...");
            };

            ws.onclose = function()
            { 
               // 关闭 websocket
               alert("连接已关闭..."); 
            };
            }
            
            else
            {
               // 浏览器不支持 WebSocket
               alert("您的浏览器不支持 WebSocket!");
            }

    };
    $scope.disconnect = function(){
        if (stompClient !== null) {
                    stompClient.disconnect();
                }
                setConnected(false);
                console.log('Disconnected');
    };

//        //进度条
//        NProgress.start();
//        //请求数据
//    	$http({
//        method: 'POST',
//        url: 'http://localhost:8080/findAll'
//    }).then(function successCallback(response) {
//        console.log("状态码:" + response.status);
//        if (response.status === 200){
//            //结束进度条
//            NProgress.done();
//            $scope.data = response.data;
//            console.log("Success...");
//            $scope.allButton.status = "成功";
//        } else {
//            NProgress.inc();
//        }
//        }, function errorCallback(response) {
//            //结束进度条
//            NProgress.inc();
//            // 请求失败执行代码
//            console.log("Fail..." + response.status);
//    });
});