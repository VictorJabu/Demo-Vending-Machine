(function() {
    var salesFactory = function($http)
    {
        var factory = {};

        factory.getSales = function()
        {
            return $http({method: 'GET', url: 'http://localhost:8080/sales'});
        };

        return factory;
    };

    angular.module('vendingMachineApp').factory('salesFactory', salesFactory);

}());