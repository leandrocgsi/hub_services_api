var app = angular.module('crudApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/',
    PESSOA_FISICA_SERVICE_API : 'http://localhost:8080/api/pessoaFisica/',
    PESSOA_JURIDICA_SERVICE_API : 'http://localhost:8080/api/pessoaJuridica/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise('/home');
        
        $stateProvider
        
            .state('home', {
                url: '/home',
                templateUrl: 'partials/home',
                controller:'HomeController',
                controllerAs:'homeCtrl',
            })
            .state('pessoaJuridica', {
                url: '/pessoaJuridica',
                templateUrl: 'partials/pessoaJuridica',
                controller:'PessoaJuridicaController',
                controllerAs:'pessoaJuridicaCtrl',
                resolve: {
                    pessoaJuridica: function ($q, PessoaJuridicaService) {
                        console.log('Listando as Pessoas Juridicas');
                        var deferred = $q.defer();
                        PessoaJuridicaService.loadAllPessoaJuridica().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    },
                    pessoaFisica: function ($q, PessoaFisicaService) {
                        console.log('Listando as Pessoas Físicas');
                        var deferred = $q.defer();
                        PessoaFisicaService.loadAllPessoaFisica().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            })
            .state('pessoaFisica', {
                url: '/pessoaFisica',
                templateUrl: 'partials/pessoaFisica',
                controller:'PessoaFisicaController',
                controllerAs:'pessoaFisicaCtrl',
                resolve: {
                    pessoaFisica: function ($q, PessoaFisicaService) {
                        console.log('Listando todas as Pessoas Fisicas');
                        var deferred = $q.defer();
                        PessoaFisicaService.loadAllPessoaFisica().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
            ;
    }]);

