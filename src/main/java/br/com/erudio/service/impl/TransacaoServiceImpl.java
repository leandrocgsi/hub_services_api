package br.com.erudio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.erudio.model.Conta;
import br.com.erudio.model.Transacao;
import br.com.erudio.repositories.ContaRepository;
import br.com.erudio.repositories.TransacaoRepository;
import br.com.erudio.service.TransacaoService;

@Service("transacaoService")
@Transactional
public class TransacaoServiceImpl implements TransacaoService{

    @Autowired
    private TransacaoRepository transacaoRepository;
    
    @Autowired
    private ContaRepository contaRepository;

    public Transacao findById(Long id) {
        return transacaoRepository.findOne(id);
    }

    public void saveTransacao(Transacao transacao) {
        
        Conta origem = contaRepository.findOne(transacao.getOrigem().getId());
        origem.setSaldo(origem.getSaldo().subtract(transacao.getValor()));
        contaRepository.save(origem);
        
        Conta destino = contaRepository.findOne(transacao.getDestino().getId());
        origem.setSaldo(origem.getSaldo().add(transacao.getValor()));
        contaRepository.save(destino);
        
        transacaoRepository.save(transacao);
    }

    public void estornoTransacao(Transacao transacao){
        Conta origem = contaRepository.findOne(transacao.getOrigem().getId());
        origem.setSaldo(origem.getSaldo().add(transacao.getValor()));
        contaRepository.save(origem);
        
        Conta destino = contaRepository.findOne(transacao.getDestino().getId());
        origem.setSaldo(origem.getSaldo().subtract(transacao.getValor()));
        contaRepository.save(destino);
        saveTransacao(transacao);
    }

    public List<Transacao> findAllTransacaos(){
        return transacaoRepository.findAll();
    }

    @Override
    public Transacao findByCodigo(String codigo) {
        return transacaoRepository.findByCodigo(codigo);
    }
}
