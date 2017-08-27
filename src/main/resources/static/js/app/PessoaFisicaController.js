'use strict';

angular.module('crudApp').controller('PessoaFisicaController',
    ['PessoaFisicaService', '$scope',  function( PessoaFisicaService, $scope) {
        var self = this;
        self.course = {};
        self.courses=[];

        self.submit = submit;
        self.getAllPessoaFisica = getAllPessoaFisica;
        self.createPessoaFisica = createPessoaFisica;
        self.updatePessoaFisica = updatePessoaFisica;
        self.removePessoaFisica = removePessoaFisica;
        self.editPessoaFisica = editPessoaFisica;
        self.reset = reset;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        function submit() {
            console.log('Submetendo');
            if (self.course.id === undefined || self.course.id === null) {
                console.log('Salvando Um Nova Pessoa Física', self.course);
                createPessoaFisica(self.course);
            } else {
                updatePessoaFisica(self.course, self.course.id);
                console.log('Atualizando a Pessoa Física com o id ', self.course.id);
            }
        }

        function createPessoaFisica(course) {
            console.log('Criação de Pessoas Físicas');
            PessoaFisicaService.createPessoaFisica(course)
                .then(
                    function (response) {
                        console.log('Pessoa Física criada com sucesso');
                        self.successMessage = 'Pessoa Física criada com sucesso';
                        self.errorMessage='';
                        self.done = true;
                        self.course={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Erro ao criar a Pessoa Física');
                        self.errorMessage = 'Erro ao criar a Pessoa Física: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function updatePessoaFisica(course, id){
            console.log('Atualização de Pessoas Físicas');
            PessoaFisicaService.updatePessoaFisica(course, id)
                .then(
                    function (response){
                        console.log('Pessoa Física atualizada com sucesso');
                        self.successMessage='Pessoa Física atualizada com sucesso';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Erro ao atualizar a Pessoa Física');
                        self.errorMessage='Erro ao atualizar a Pessoa Física '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }


        function removePessoaFisica(id){
            console.log('Remoção de Pessoa Física com o id '+id);
            PessoaFisicaService.removePessoaFisica(id)
                .then(
                    function(){
                        console.log('Pessoa Física de id '+id + ' removida com sucesso');
                    },
                    function(errResponse){
                        console.error('Erro ao remover a Pessoa Física '+id +', Erro :'+errResponse.data);
                    }
                );
        }


        function getAllPessoaFisica(){
            return PessoaFisicaService.getAllPessoaFisica();
        }

        function editPessoaFisica(id) {
            self.successMessage='';
            self.errorMessage='';
            PessoaFisicaService.getPessoaFisica(id).then(
                function (course) {
                    self.course = course;
                },
                function (errResponse) {
                    console.error('Erro ao remover a Pessoa Física ' + id + ', Error :' + errResponse.data);
                }
            );
        }
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.course={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }
]);