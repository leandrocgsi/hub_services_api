package br.com.erudio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.erudio.model.Pessoa;
import br.com.erudio.repositories.PessoaRepository;
import br.com.erudio.service.PessoaService;

@Service("pessoaService")
@Transactional
public class PessoaServiceImpl implements PessoaService{

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public List<Pessoa> findAllPessoa() {
        return pessoaRepository.findAll();
    }
}
