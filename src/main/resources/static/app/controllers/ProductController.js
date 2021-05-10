app.controller('ProductController', function ($scope, productFactory) {
    $scope.sortBy = 'name';
    $scope.alertWrongAmount = true;
    $scope.totalAmount = 0;
    $scope.counter20c = 0;
    $scope.counter50c = 0;
    $scope.counterR1 = 0;
    $scope.counterR5 = 0;
    $scope.denominationsReceived = '';

    function init() {
        $scope.products = productFactory.getProducts().success(function (products) {
            $scope.products = products;
        })
            .error(function (data, status, headers, config) {
                //Handle Errors
            });
    }

    $scope.checkSomething = function(){
        return $scope.amount !== '20c' && $scope.amount !== '50c' && $scope.amount !== 'R1' && $scope.amount !== 'R5';
    }

    $scope.addAmount = function() {
        if($scope.amount === '20c') {
            $scope.counter20c++;
            $scope.totalAmount = $scope.totalAmount + 0.20; 
        } else if($scope.amount === '50c'){
            $scope.counter50c++;
            $scope.totalAmount = $scope.totalAmount + 0.50; 
        }else if($scope.amount === 'R1'){
            $scope.counterR1++;
            $scope.totalAmount = $scope.totalAmount + 1;   
        }else if($scope.amount === 'R5'){
            $scope.counterR5++;
            $scope.totalAmount = $scope.totalAmount + 5;
        }
        $scope.denominationsReceived = $scope.counter20c + 'x' + ' 20c ' + $scope.counter50c + 'x' + ' 50c ' + $scope.counterR1 + 'x' + ' R1 ' + $scope.counterR5 + 'x' + ' R5 ';
        console.log($scope.denominationsReceived);
        $scope.amount = '';
    }
    
    $scope.purchaseProduct = function(price, productName)
    {
        console.log(price, productName);
        $scope.change = $scope.totalAmount - price;
        $scope.data = {productName: productName, price: price, amountPaid: $scope.totalAmount, denominationsReceived: $scope.denominationsReceived, change: $scope.change};
        if($scope.totalAmount >= price)
        {
            productFactory.productPurchase($scope.data).success(function (sale) {
                if($scope.change === 0.5) {
                    alert("your change is 50c");
                } else if($scope.change === 0.2){
                    alert("your change is 20c");
                }else if($scope.change === 1){
                    alert("your change is R1");
                }else if($scope.change === 5){
                    alert("your change is R5");
                }
            })
                .error(function (data, status, headers, config) {
                    //Handle Errors
                });

            $scope.totalAmount = 0;
        }else {
            alert("Please enter the right amount for the product!");
        }
    }
    
    $scope.doSort = function(propName) {
        $scope.sortBy = propName;
        $scope.reverse = !$scope.reverse;
    };

    init();
});