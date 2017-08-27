package br.com.erudio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.erudio.model.PessoaFisica;
import br.com.erudio.repositories.PessoafisicaRepository;
import br.com.erudio.service.PessoaFisicaService;



@Service("pessoafisicaService")
@Transactional
public class PessoaFisicaServiceImpl implements PessoaFisicaService{

    @Autowired
    private PessoafisicaRepository pessoafisicaRepository;

    public PessoaFisica findById(Long id) {
        return pessoafisicaRepository.findOne(id);
    }

    public PessoaFisica findByName(String name) {
        return pessoafisicaRepository.findByNomeNomeFantasia(name);
    }

    public void savePessoaFisica(PessoaFisica pessoaFisica) {
        pessoafisicaRepository.save(pessoaFisica);
    }

    public void updatePessoaFisica(PessoaFisica pessoaFisica){
        savePessoaFisica(pessoaFisica);
    }

    public void deletePessoaFisicaById(Long id){
        pessoafisicaRepository.delete(id);
    }

    public void deleteAllPessoaFisicas(){
        pessoafisicaRepository.deleteAll();
    }

    public List<PessoaFisica> findAllPessoaFisicas(){
        return pessoafisicaRepository.findAll();
    }

    public boolean isPessoaFisicaExist(PessoaFisica pessoaFisica) {
        return findByName(pessoaFisica.getNomeNomeFantasia()) != null;
    }
}
