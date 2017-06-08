<!DOCTYPE html>
<html ng-app>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no, width=device-width">
    <title>test</title>
    <script src="/js/jquery.min.3.2.1.js"></script>
    <script src="/js/angular.min.js"></script>
    <script src="/js/angular-route.js"></script>
    <script src="/server/main.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/nprogress.js"></script>
    <!--<script src="/ionic.bundle.min.js"></script>-->
    <link href="/css/nprogress.css" rel="stylesheet">
    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/bootstrap-theme.min.css" rel="stylesheet">
</head>

    <body ng-controller="UserController">
        
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#">
                          <img alt="Brand" src="...">
                        </a>
                    </div>
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#/home">Home</a></li>
                        <li><a href="#/about">About</a></li>
                    </ul>
                    <form class="navbar-form navbar-left" role="search">
                        <div class="form-group">
                          <input type="text" class="form-control" placeholder="Search">
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                    <p class="navbar-text navbar-right">Signed in as <a href="#" class="navbar-link">Mark Otto</a></p>
                </div>
            </div>
        </nav>
        <div ng-view=""></div>
        {{allStatus.status}}


        <form class="form-inline">
            <div class="form-group">
                <label for="exampleInputName2">Name</label>
                <input type="text" class="form-control" ng-model="par.name" placeholder="zhangsan">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail2">Pwd</label>
                <input type="password" class="form-control" ng-model="par.pwd" placeholder="123456">
            </div>
        <button type="submit" class="btn btn-primary" ng-click="save()">{{allStatus.save}}</button>
        </form>

        <div class="table-responsive">
        <table class="table">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Name</th>
                    <th>Pwd</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <tr ng-repeat="stooge in names">
                    <th scope="row">{{stooge.id}}</th>
                    <td>{{stooge.name}}</td>
                    <td>{{stooge.pwd}}</td>
                    <td><button type="button" class="btn btn-warning" ng-click="findById(stooge.id)">{{allStatus.update}}</button></td>
                    <td><button type="button" class="btn btn-danger" ng-click="del(stooge.id)">{{allStatus.del}}</button></td>
                </tr>
            </tbody>
        </table>
        </div>

    <!-- 引入微 -->
    <#include "/footer.ftl">
    </body>
</html>