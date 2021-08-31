angular.module('market-front').controller('cartController', function ($scope, $http, $location) {
    const contextPath = 'http://localhost:8189/market/';


$scope.loadCart = function () {
    $http.get(contextPath + 'api/v1/carts/')
            .then(function successCallback (response) {
                $scope.updated_product = response.data;
            }, function failureCallback (response) {
                console.log(response);
                alert(response.data.messages);
                $location.path('/store');
            });
});