package br.com.erudio.service;


import java.util.List;

import br.com.erudio.model.PessoaFisica;

public interface PessoaFisicaService {
    
    PessoaFisica findById(Long id);

    PessoaFisica findByName(String name);

    void savePessoaFisica(PessoaFisica pessoaFisica);

    void updatePessoaFisica(PessoaFisica pessoaFisica);

    void deletePessoaFisicaById(Long id);

    void deleteAllPessoaFisicas();

    List<PessoaFisica> findAllPessoaFisicas();

    boolean isPessoaFisicaExist(PessoaFisica pessoaFisica);
}