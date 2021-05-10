 var app = angular.module('vendingMachineApp', ['ngRoute']);

app.config(function($routeProvider){
    $routeProvider
      .when('/',{
        controller: 'ProductController',
        templateUrl: 'views/vendingMachine.html'
    })
      .when('/overallData', {
        controller: 'SalesController',
        templateUrl: 'views/overallData.html'
    })
    .otherwise({redirectTo: '/'});
});