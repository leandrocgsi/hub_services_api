package br.com.erudio.service;


import java.util.List;

import br.com.erudio.model.PessoaJuridica;

public interface PessoaJuridicaService {
    
    PessoaJuridica findById(Long id);

    PessoaJuridica findByName(String name);

    void savePessoaJuridica(PessoaJuridica pessoaJuridica);

    void updatePessoaJuridica(PessoaJuridica pessoaJuridica);

    void deletePessoaJuridicaById(Long id);

    void deleteAllPessoaJuridicas();

    List<PessoaJuridica> findAllPessoaJuridicas();

    boolean isPessoaJuridicaExist(PessoaJuridica pessoaJuridica);
}