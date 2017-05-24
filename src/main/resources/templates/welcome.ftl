<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no, width=device-width">
    <title>test</title>
    <link href="/ionic.css" rel="stylesheet">
    <script src="/ionic.bundle.min.js"></script>
    <script src="/angular.min.js"></script>
    <script src="/Name.js"></script>
</head>
    <body ng-app="myApp" ng-controller="myCtrl">
        <!-- 添加用户 -->
        <div class="bar bar-header">
            <div class="h1 title">{{allStatus.save}}</div>
        </div>

        <div class="content has-header">
        <div class="list">
            <label class="item item-input">
              <span class="input-label">Username</span>
              <input type="text" ng-model="par.name">
            </label>
            <label class="item item-input">
              <span class="input-label">Password</span>
              <input type="password" ng-model="par.pwd">
            </label>
        </div>
        <div class="padding">
            <button class="button button-block button-positive" ng-click="save()">{{allStatus.save}}</button>
        </div>
        </div>

        <!--  显示全部用户数据 -->
        <div class="bar bar-header">
            <div class="h1 title">{{allStatus.status}}</div>
        </div>
        
        <div class="content has-header ionic-pseudo">
            <div class="list">
                <div class="item item-button-right" ng-repeat="stooge in names" ng-click="findById(stooge.id)">
                    {{stooge.name}},{{stooge.pwd}}
                    <button class="button button-positive" ng-click="del(stooge.id)">
                        <i class="icon ion-ios-telephone"></i>
                    </button>
                </div>
            </div>
        </div>
        <div style="height:100px;"></div>
<!-- 
        <ion-view title="Index">
        <ion-content has-header="true">
          <ion-list>
            <ion-item ng-repeat="stooge in names" href="#">{{stooge.name}},{{stooge.pwd}},
                <button class="button button-clear button-positive" ng-click="del(stooge.id)">
                    {{allStatus.del}}
                </button>
            </ion-item>
          </ion-list>
        </ion-content>
      </ion-view>
 -->
<!-- 
        <h2>{{allStatus.status}}</h2>
                name:<input ng-model="par.name" />
                {{par.name}}
                
                pwd:<input ng-model="par.pwd" />
                {{par.pwd}}

            <button ng-click="save()">{{allStatus.save}}</button>
            <button ng-click="findAll()">{{allStatus.button}}</button>
            <ul>
                <li ng-repeat="x in names" ng-click="del(x.id)">
                        {{ x.id + ', ' + x.name + ', ' + x.pwd }},{{allStatus.del}}
                </li>
            </ul>
 -->
    </body>
</html>