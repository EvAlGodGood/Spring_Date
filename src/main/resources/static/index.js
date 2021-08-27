angular.module('market-front', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/market/api/';

    var page = 1;

    $scope.pagePlus = function () {
        if(page<$scope.productsPage.totalPages){
            page++;
        }
        $scope.loadProducts(page);

    }
    $scope.pageMinus = function () {
        if (page>1){
            page--;
        }
        $scope.loadProducts(page);

    }

    $scope.generatePagesIndexes = function (startPage, endPage) {
           let arr = [];
           for (let i = startPage; i < endPage + 1; i++) { //создали список страниц
               arr.push(i);
           }
           return arr;
        }

    $scope.loadProducts = function (pageIndex = page) {
        page = pageIndex;
        $http({
            url: contextPath + 'v1/products',
            method: 'GET',
            params: {
                p: pageIndex
            }
        }).then(function (response) {
            console.log(response);
            $scope.productsPage = response.data;
            $scope.paginationArray = $scope.generatePagesIndexes(1, $scope.productsPage.totalPages); //для отрисовки кнопок/страниц
        });
    };
//вывод алерта
    $scope.showInfo = function (product) {
        alert(product.id + ' ' + product.title + ' ' + product.price);
    };

    $scope.deleteId = function (product) {
       $http.delete(contextPath + 'v1/products/'+ product.id)
         .then(function (response) {
               $scope.loadProducts();
         });
    };

    $scope.createNewProduct = function () {
       $http.post(contextPath + 'v1/products', $scope.new_product)
         .then(function successCallback (response) {
                $scope.loadProducts($scope.productsPage.totalPages);
                $scope.new_product = null;
         }, function failureCallback (response) {//алерт если что-то не так
                alert(response.data.message);
       });
    }

    $scope.loadProducts();

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
 // $scope.loadProducts = function () {
    //     $http.get(contextPath + 'products')
    //         .then(function (response) {
    //             console.log(response);
    //             $scope.productsPage = response.data;
    //         });
    // };

});
