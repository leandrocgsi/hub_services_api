package br.com.erudio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.erudio.model.PessoaJuridica;
import br.com.erudio.repositories.PessoaJuridicaRepository;
import br.com.erudio.service.PessoaJuridicaService;



@Service("pessoaJuridicaService")
@Transactional
public class PessoaJuridicaServiceImpl implements PessoaJuridicaService{

    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepository;

    public PessoaJuridica findById(Long id) {
        return pessoaJuridicaRepository.findOne(id);
    }

    public PessoaJuridica findByName(String name) {
        return pessoaJuridicaRepository.findByNomeNomeFantasia(name);
    }

    public void savePessoaJuridica(PessoaJuridica pessoaJuridica) {
        pessoaJuridicaRepository.save(pessoaJuridica);
    }

    public void updatePessoaJuridica(PessoaJuridica pessoaJuridica){
        savePessoaJuridica(pessoaJuridica);
    }

    public void deletePessoaJuridicaById(Long id){
        pessoaJuridicaRepository.delete(id);
    }

    public void deleteAllPessoaJuridicas(){
        pessoaJuridicaRepository.deleteAll();
    }

    public List<PessoaJuridica> findAllPessoaJuridicas(){
        return pessoaJuridicaRepository.findAll();
    }

    public boolean isPessoaJuridicaExist(PessoaJuridica pessoaJuridica) {
        return findByName(pessoaJuridica.getNomeNomeFantasia()) != null;
    }
}
