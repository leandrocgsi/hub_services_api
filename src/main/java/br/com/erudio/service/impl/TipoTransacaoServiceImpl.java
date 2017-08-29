package br.com.erudio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.erudio.model.TipoTransacao;
import br.com.erudio.repositories.TipoTransacaoRepository;
import br.com.erudio.service.TipoTransacaoService;

@Service("tipoTransacaoService")
@Transactional
public class TipoTransacaoServiceImpl implements TipoTransacaoService{

    @Autowired
    private TipoTransacaoRepository tipoTransacaoRepository;

    @Override
    public List<TipoTransacao> findAllTipoTransacao() {
        return tipoTransacaoRepository.findAll();
    }
}
