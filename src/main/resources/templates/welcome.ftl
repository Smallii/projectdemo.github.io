<!DOCTYPE html>
<html ng-app="myApp">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no, width=device-width">
    <title>test</title>
    <script src="/jquery.min.3.2.1.js"></script>
    <script src="/angular.min.js"></script>
    <script src="/bootstrap.min.js"></script>
    <script src="/nprogress.js"></script>
    <script src="/Name.js"></script>
    <!--<script src="/ionic.bundle.min.js"></script>-->
    <link href="/nprogress.css" rel="stylesheet">
    <link href="/bootstrap.min.css" rel="stylesheet">
    <link href="/bootstrap-theme.min.css" rel="stylesheet">
    <!--<link href="/ionic.css" rel="stylesheet">-->
    
</head>
    <body ng-controller="myCtrl">
    

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					确定删除吗？
				</h4>
			</div>
                        <!--
			<div class="modal-body">
				在这里添加一些文本
			</div>
                        -->
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">取消
				</button>
				<button type="button" class="btn btn-primary">
					删除
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>


        <!-- 引入头 -->
        <#include "/header.ftl">
        
        

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