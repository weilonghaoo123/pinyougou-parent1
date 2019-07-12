//品牌服务   先有服务后有控制层，服务请求后端后返回数据（model)，控制层操作demol，model最后渲染视图view
app.service('brandService', function ($http) {
    this.findAll = function () {
        return $http.get('../brand/findAll.do');
    };

    this.findPage = function (page, size) {
        return $http.get('../brand/findPage.do?page=' + page + '&size=' + size);
    };

    this.findOne = function (id) {
        return $http.get('../brand/findOne.do?id=' + id);
    };

    this.add = function (entity) {
        return $http.post('../brand/add.do', entity)
    };

    this.update = function (entity) {
        return $http.post('../brand/update.do', entity)
    };
    this.delete = function (ids) {
        return $http.get('../brand/delete.do?ids=' + ids);

    };
    this.search = function (page, size, searchEntity) {
        return $http.post('../brand/search.do?page=' + page + '&size=' + size, searchEntity);
    }
    this.selectOptionList=function () {
        return $http.get('../brand/selectOptionList.do')
    }
});