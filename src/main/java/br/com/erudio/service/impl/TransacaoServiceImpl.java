package br.com.erudio.service.impl;

import java.math.BigDecimal;
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
        BigDecimal saldoOrigem = origem.getSaldo().subtract(transacao.getValor());
        contaRepository.updateSaldo(saldoOrigem, origem.getId());
        
        Conta destino = contaRepository.findOne(transacao.getDestino().getId());
        BigDecimal saldoDestino = origem.getSaldo().add(transacao.getValor());
        contaRepository.updateSaldo(saldoDestino, destino.getId());
        
        transacaoRepository.save(transacao);
    }

    public void estornoTransacao(Transacao transacao){
        Conta origem = contaRepository.findOne(transacao.getOrigem().getId());
        BigDecimal saldoOrigem = origem.getSaldo().add(transacao.getValor());
        contaRepository.updateSaldo(saldoOrigem, origem.getId());
        
        Conta destino = contaRepository.findOne(transacao.getDestino().getId());
        BigDecimal saldoDestino = origem.getSaldo().subtract(transacao.getValor());
        contaRepository.updateSaldo(saldoDestino, destino.getId());
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
