angular.module('market-front', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/market/';

    var page = 0;

    // $scope.loadProducts = function () {
    //     $http.get(contextPath + 'products')
    //         .then(function (response) {
    //             console.log(response);
    //             $scope.productsPage = response.data;
    //         });
    // };
    $scope.pagePlus = function () {
        page++;
        $scope.loadProducts(page);
    }
    $scope.pageMinus = function () {
        page--;
        $scope.loadProducts(page);
    }

    $scope.loadProducts = function (pageIndex = page) {
        $http({
            url: contextPath + 'products',
            method: 'GET',
            params: {
                p: pageIndex
            }
        }).then(function (response) {
            console.log(response);
            $scope.productsPage = response.data;
        });
    };
//вывод алерта
    $scope.showInfo = function (product) {
        alert(product.id + ' ' + product.title + ' ' + product.price);
    };

    $scope.deleteId = function (product) {
       $http.get(contextPath + 'products/delete/'+ product.id)
         .then(function (response) {
               $scope.loadProducts();
         });
    };

    // $scope.wrongRequest = function () {
    // WRONG:
    // $http.get(contextPath + 'products/update/1');
    // reload();

    // CORRECT
    // $http.get(contextPath + 'products/update/1')
    //     .then(function (response) {
    //         reload();
    //     });
    // }

    $scope.loadProducts();
});
