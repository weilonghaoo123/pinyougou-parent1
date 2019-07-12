//品牌控制
app.controller('brandController', function ($scope, $controller, brandService) {
    $controller('baseController', {$scope: $scope});
    //查询品牌列表
    $scope.findAll = function () {
        brandService.findAll().success(
            function (response) {
                $scope.list = response;
            }
        );
    };


    $scope.findPage = function (page, size) {
        brandService.findPage(page, size).success(
            function (response) {
                $scope.list = response.rows;//显示当前页数据
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        )
    };
    //新增修改品牌
    $scope.save = function () {
        var Object = null;
        if ($scope.entity.id != null) {
            Object = brandService.update($scope.entity);
        } else {
            Object = brandService.add($scope.entity);
        }
        Object.success(
            function (response) {
                if (response.success) {
                    $scope.reloadList();//成功后刷新
                } else {
                    alert(response.message);
                }
            }
        )
    };
    //查询实体
    $scope.findOne = function (id) {
        brandService.findOne(id).success(
            function (response) {
                $scope.entity = response;
            }
        )
    };

    //批量删除
    $scope.delete = function (ids) {
        brandService.delete($scope.selectIds).success(
            function (response) {
                if (response.success) {
                    $scope.reloadList();//成功后刷新
                } else {
                    alert(response.message);
                }
            }
        )
    };
    //分页模糊查询
    $scope.searchEntity = {};
    $scope.search = function (page, size) {
        brandService.search(page, size, $scope.searchEntity).success(
            function (response) {
                $scope.list = response.rows;//显示当前页数据
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        )
    };
});