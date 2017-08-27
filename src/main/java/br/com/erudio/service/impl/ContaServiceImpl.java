package br.com.erudio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.erudio.model.Conta;
import br.com.erudio.repositories.ContaRepository;
import br.com.erudio.service.ContaService;

@Service("contaService")
@Transactional
public class ContaServiceImpl implements ContaService{

    @Autowired
    private ContaRepository contaRepository;

    public Conta findById(Long id) {
        return contaRepository.findOne(id);
    }

    public Conta findByName(String name) {
        return contaRepository.findByNome(name);
    }

    public void saveConta(Conta conta) {
        contaRepository.save(conta);
    }

    public void updateConta(Conta conta){
        saveConta(conta);
    }

    public void deleteContaById(Long id){
        contaRepository.delete(id);
    }

    public void deleteAllContas(){
        contaRepository.deleteAll();
    }

    public List<Conta> findAllContas(){
        return contaRepository.findAll();
    }

    public boolean isContaExist(Conta conta) {
        return findByName(conta.getNome()) != null;
    }
}
