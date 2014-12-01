'use strict';

var app = angular
  .module('BaerenBande', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
      .when('/', {
        templateUrl: 'views/Home.html',
        controller: 'MainCtrl'
      })
      .when('/cart', {
        templateUrl: 'views/Cart.html',
        controller: 'CartCtrl'
      })  
      .when('/details', {
        templateUrl: 'views/Details.html',
        controller: 'DetailsCtrl'
      })  
      .when('/search', {
        templateUrl: 'views/SearchResult.html',
        controller: 'SearchResultCtrl'
      })
      .when('/login', {
          templateUrl: 'views/Login.html',
          controller: 'LoginCtrl'
        })  
      .when('/register', {
          templateUrl: 'views/Register.html',
          controller: 'RegisterCtrl'
        })  
      .otherwise({
        redirectTo: '/'
      });
  }]);