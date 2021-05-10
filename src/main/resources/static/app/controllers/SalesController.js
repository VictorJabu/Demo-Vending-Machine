app.controller('SalesController', function ($scope, salesFactory) {
    function init() {
        $scope.sales = salesFactory.getSales().success(function (sales) {
            $scope.sales = sales;
            console.log($scope.sales);
        })
            .error(function (data, status, headers, config) {
                //Handle Errors
            });
    }
    init()
});