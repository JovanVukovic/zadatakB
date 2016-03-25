var zadatakB = angular.module('zadatakB.routes', ['ngRoute']);

zadatakB.config(['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl : 'static/html/home.html',
            controller : 'Matches'	
        })
        .otherwise({
            redirectTo: '/'
        });
}]);