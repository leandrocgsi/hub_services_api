package br.com.erudio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.erudio.model.PessoaFisica;
import br.com.erudio.repositories.PessoaFisicaRepository;
import br.com.erudio.service.PessoaFisicaService;



@Service("pessoaFisicaService")
@Transactional
public class PessoaFisicaServiceImpl implements PessoaFisicaService{

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    public PessoaFisica findById(Long id) {
        return pessoaFisicaRepository.findOne(id);
    }

    public PessoaFisica findByName(String name) {
        return pessoaFisicaRepository.findByNomeNomeFantasia(name);
    }

    public void savePessoaFisica(PessoaFisica pessoaFisica) {
        pessoaFisicaRepository.save(pessoaFisica);
    }

    public void updatePessoaFisica(PessoaFisica pessoaFisica){
        savePessoaFisica(pessoaFisica);
    }

    public void deletePessoaFisicaById(Long id){
        pessoaFisicaRepository.delete(id);
    }

    public void deleteAllPessoaFisicas(){
        pessoaFisicaRepository.deleteAll();
    }

    public List<PessoaFisica> findAllPessoaFisicas(){
        return pessoaFisicaRepository.findAll();
    }

    public boolean isPessoaFisicaExist(PessoaFisica pessoaFisica) {
        return findByName(pessoaFisica.getNomeNomeFantasia()) != null;
    }
}
