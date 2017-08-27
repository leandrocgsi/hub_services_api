package br.com.erudio.service;


import java.util.List;

import br.com.erudio.model.Pessoa;

public interface PessoaService {
    
    List<Pessoa> findAllPessoa();

}