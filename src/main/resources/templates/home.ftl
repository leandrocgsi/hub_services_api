<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Página Inicial</span></div>
        <div class="panel-body">
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="homeCtrl.successMessage">{{homeCtrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="homeCtrl.errorMessage">{{homeCtrl.errorMessage}}</div>
                <form name="myForm" class="form-horizontal">
                    <div class="row">
                        <div class="form-actions floatRight">
                        <a  ng-href="#/pessoaFisica">
                            <button type="button" ng-click="homeCtrl.addPessoaFisica()" class="btn btn-primary btn-sm">Adicionar Pessoas Fisicas</button>
                        </a>
                        <a  ng-href="#/pessoaJuridica">
                            <button type="button" ng-click="homeCtrl.addPessoaJuridica()" class="btn btn-primary btn-sm">Adicionar Pessoas Juridicas</button>
                        </a>
                        </div>
                    </div>
                </form>
            </div>
        </div>    
    </div>
</div>