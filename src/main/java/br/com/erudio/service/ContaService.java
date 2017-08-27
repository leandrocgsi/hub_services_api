package br.com.erudio.service;


import java.util.List;

import br.com.erudio.model.Conta;

public interface ContaService {
    
    Conta findById(Long id);

    Conta findByName(String name);

    void saveConta(Conta conta);

    void updateConta(Conta conta);

    void deleteContaById(Long id);

    void deleteAllContas();

    List<Conta> findAllContas();

    boolean isContaExist(Conta conta);
}