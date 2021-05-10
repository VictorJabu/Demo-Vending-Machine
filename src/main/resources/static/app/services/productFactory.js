(function() {
    var productFactory = function($http)
    {
        var factory = {};

        factory.getProducts = function()
        {
            return $http({method: 'GET', url: 'http://localhost:8080/products'});
        };

        factory.productPurchase = function (data)
        {
            return $http({
                method: 'POST',
                url: 'http://localhost:8080/purchaseProduct',
                data: data
            })
        };
        
        return factory;
    };
    
angular.module('vendingMachineApp').factory('productFactory', productFactory); 
    
}());