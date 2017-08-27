<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Pessoa Jurídica</span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	            <div class="alert alert-success" role="alert" ng-if="pessoaJuridicaCtrl.successMessage">{{pessoaJuridicaCtrl.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="pessoaJuridicaCtrl.errorMessage">{{pessoaJuridicaCtrl.errorMessage}}</div>
	            <form ng-submit="pessoaJuridicaCtrl.submit()" name="myForm" class="form-horizontal">
	                <input type="hidden" ng-model="pessoaJuridicaCtrl.pessoaJuridica.id" />

	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="age">CPF</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="pessoaJuridicaCtrl.pessoaJuridica.id.id" id="cpf" class="form-control input-sm" placeholder="Digite o CNPJ da Pessoa Jurídica" required ng-pattern="pessoaJuridicaCtrl.onlyIntegers"/>
	                        </div>
	                    </div>
	                </div>
	                
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="uname">N° de Matrícula</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="pessoaJuridicaCtrl.pessoaJuridica.id.registration" id="registration" class="pessoaJuridicaname form-control input-sm" placeholder="Digite o N° de Matrícula" required ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>
	                
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="uname">Nome</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="pessoaJuridicaCtrl.pessoaJuridica.name" id="uname" class="pessoaJuridicaname form-control input-sm" placeholder="Digite o Nome" required ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>
	
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        
	                      <label class="col-md-2 for="pessoaFisica">Pessoa Física</label>
	                      <select class="col-md-7"  style="pessoaJuridicaname form-control input-sm ng-pristine ng-valid-minlength ng-not-empty ng-valid ng-valid-required ng-touched"   ng-model="pessoaJuridicaCtrl.pessoaJuridica.nomeNomeFantasia">
	                          <option ng-selected="{{u.id == filterCondition.u.id}}" 
	                              ng-repeat="u in pessoaJuridicaCtrl.courses"
	                              value="{{u.id}}">
	                              {{u.name}}
	                          </option>
	                      </select>
	                    </div>
	                </div>

	                <div class="row">
	                    <div class="form-actions floatRight">
	                        <input type="submit"  value="{{!courseCtrl.pessoaJuridica ? 'Salvar' : 'Salvar'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
	                        
	                        <button type="button" ng-click="pessoaJuridicaCtrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Limpar</button>
	                    </div>
	                </div>
	            </form>
    	    </div>
		</div>	
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Lista de Pessoas Jurídicas</span></div>
		<div class="panel-body">
			<div class="table-responsive">
		        <table class="table table-hover">
		            <thead>
		            <tr>
		                <th>CPF</th>
		                <th>N° de Matrícula</th>
		                <th>Nome</th>
		                <th>XYZ</th>
		                <th width="100"></th>
		                <th width="100"></th>
		            </tr>
		            </thead>
		            <tbody>
		            <tr ng-repeat="u in pessoaJuridicaCtrl.getAllPessoaJuridica()">
		                <td>{{u.id.id}}</td>
		                <td>{{u.id.registration}}</td>
		                <td>{{u.name}}</td>
		                <td>{{u.course.name}}</td>
		                <td><button type="button" ng-click="pessoaJuridicaCtrl.editPessoaJuridica(u.id)" class="btn btn-success custom-width">Editar</button></td>
		                <td><button type="button" ng-click="pessoaJuridicaCtrl.removePessoaJuridica(u.id)" class="btn btn-danger custom-width">Remover</button></td>
		            </tr>
		            </tbody>
		        </table>		
			</div>
		</div>
    </div>
</div>