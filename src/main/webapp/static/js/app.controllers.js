var zadatakB = angular.module('zadatakB.controllers', [ 'ngAnimate','ui.bootstrap' ]);

zadatakB.controller('Matches', function($scope, $http, $location, $routeParams) {
	
			$scope.initMatches = function() {
				$scope.exampleout = {};
			};
			
			$scope.successData= false;
			$scope.errorData=false;

			$scope.getMatches = function() {
				
				$http.post('api/matches', $scope.exampleInput)
					.success(function(data, status) {
						$scope.exampleout = data;
						$scope.successData= true;
						$scope.errorData=false;
	
					}).error(function(data,status) {
						alert('Oops, something went wrong...')
						$scope.error = data;
						$scope.successData= false;
						$scope.errorData=true;
					})
			};
		});
