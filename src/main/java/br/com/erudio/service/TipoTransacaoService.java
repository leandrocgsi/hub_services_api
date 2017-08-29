package br.com.erudio.service;

import java.util.List;

import br.com.erudio.model.TipoTransacao;

public interface TipoTransacaoService {
    
    List<TipoTransacao> findAllTipoTransacao();

}