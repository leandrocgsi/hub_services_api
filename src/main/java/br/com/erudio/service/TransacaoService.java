package br.com.erudio.service;


import java.util.List;

import br.com.erudio.model.Transacao;

public interface TransacaoService {
    
    Transacao findById(Long id);

    Transacao findByCodigo(String codigo);

    void saveTransacao(Transacao transacao);

    void estornoTransacao(Transacao transacao);

    List<Transacao> findAllTransacaos();

}