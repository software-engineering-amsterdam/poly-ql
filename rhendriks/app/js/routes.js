define(['angular', 'app'], function(angular, app) {
	'use strict';

	return app.config(['$routeProvider', function($routeProvider) {
		$routeProvider.when('/main', {
			templateUrl: 'app/partials/main.html',
			controller: 'control1'
		});
		$routeProvider.otherwise({redirectTo: '/main'});
	}]);

});