package br.com.erudio.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.model.Transacao;
import br.com.erudio.service.TransacaoService;
import br.com.erudio.util.CustomErrorType;

@SuppressWarnings({ "rawtypes", "unchecked" })
@RestController
@RequestMapping("/api")
public class TransacaoController {

    public static final Logger logger = LoggerFactory.getLogger(TransacaoController.class);

    @Autowired
    TransacaoService transacaoService;

    @RequestMapping(value = "/transacao/", method = RequestMethod.GET)
    public ResponseEntity<List<Transacao>> listAllTransacaos() {
        List<Transacao> transacaos = transacaoService.findAllTransacaos();
        if (transacaos.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<Transacao>>(transacaos, HttpStatus.OK);
    }

    @RequestMapping(value = "/transacao/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getTransacao(@PathVariable("id") long id) {
        logger.info("Recuperando Transacao de ID " + id);
        Transacao transacao = transacaoService.findById(id);
        if (transacao == null) {
            logger.error("Transacao de id " + id + " não encontrada");
            return new ResponseEntity(new CustomErrorType("Transacao de id " + id + " não encontrada"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Transacao>(transacao, HttpStatus.OK);
    }

    @RequestMapping(value = "/transacao", method = RequestMethod.POST)
    public ResponseEntity<?> createTransacao(@RequestBody Transacao transacao) {
        logger.info("Cadastrando uma nova Transacao : " + transacao);
        
        transacao.setCodigo(getCodigoAlfanumerico());
        transacao.setDataTransacao(new Date());
        transacao.setEstornada(false);
        
        transacaoService.saveTransacao(transacao);

        return new ResponseEntity<Transacao>(transacao, HttpStatus.OK);
    }

    @RequestMapping(value = "/transacao/estornoTransacao/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> estornoTransacao(@PathVariable("id") long id, @RequestBody Transacao transacao) {
        logger.info("Atualizando a Transacao de ID: " + id);

        transacao.setEstornada(true);
        Transacao currentTransacao = transacaoService.findById(id);

        if (currentTransacao == null) {
            logger.error("Não foi possível atualizar esta transacao. Transacao com o ID " + id + " não localizada");
            return new ResponseEntity(new CustomErrorType("Não foi possível atualizar esta transacao. Transacao com o ID " + id + " não localizada"), HttpStatus.NOT_FOUND);
        }

        transacaoService.estornoTransacao(transacao);
        return new ResponseEntity<Transacao>(transacao, HttpStatus.OK);
    }
    
    private String getCodigoAlfanumerico() {
        String uuid = UUID.randomUUID().toString();
        String[] uuidVector = uuid.split("-");
        return uuidVector[0].toUpperCase();
    }
}