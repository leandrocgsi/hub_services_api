package br.com.erudio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.erudio.model.TipoConta;
import br.com.erudio.repositories.TipoContaRepository;
import br.com.erudio.service.TipoContaService;

@Service("tipoContaService")
@Transactional
public class TipoContaServiceImpl implements TipoContaService{

    @Autowired
    private TipoContaRepository tipoContaRepository;

    @Override
    public List<TipoConta> findAllTipoConta() {
        return tipoContaRepository.findAll();
    }
}
