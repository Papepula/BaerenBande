'use strict';

var app = angular
  .module('BaerenBande', [
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'ui.bootstrap'
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
      .when('/details/:id', {
        templateUrl: 'views/Details.html',
        controller: 'DetailsCtrl'
      })  
      .when('/search/:searchText', {
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
      .when('/order', {
          templateUrl: 'views/Order.html',
          controller: 'OrderCtrl'
        })  
        .when('/confirm', {
            templateUrl: 'views/OrderConfirm.html',
            controller: 'OrderConfirmCtrl'
        })
        .when('/error', {
            templateUrl: 'views/OrderError.html',
            controller: 'OrderErrorCtrl'
        })
      .otherwise({
        redirectTo: '/'
      });
  }]);