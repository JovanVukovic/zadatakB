var zadatakB = angular.module('zadatakB.controllers', [ 'ngAnimate','ui.bootstrap' ]);

zadatakB.controller('Matches', function($scope, $http, $location, $routeParams) {
	
			$scope.initMatches = function() {
				$scope.exampleout = {};
			};
			
			$scope.exampleInput = "";

			$scope.getMaches = function() {
				// GET api/users
				$http.post('api/matches')
					.success(function(data, status) {
						$scope.exampleout = data;
	
					}).error(function() {
						alert('Oops, something went wrong...')
					})
			};
		});
