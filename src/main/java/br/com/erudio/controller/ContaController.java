package br.com.erudio.controller;

import java.util.Date;
import java.util.List;

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

import br.com.erudio.model.Conta;
import br.com.erudio.service.ContaService;
import br.com.erudio.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class ContaController {

    public static final Logger logger = LoggerFactory.getLogger(ContaController.class);

    @Autowired
    ContaService contaService;

    @RequestMapping(value = "/conta/", method = RequestMethod.GET)
    public ResponseEntity<List<Conta>> listAllContas() {
        List<Conta> contas = contaService.findAllContas();
        if (contas.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<Conta>>(contas, HttpStatus.OK);
    }

    @RequestMapping(value = "/conta/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getConta(@PathVariable("id") long id) {
        logger.info("Recuperando Conta de ID " + id);
        Conta conta = contaService.findById(id);
        if (conta == null) {
            logger.error("Conta de id " + id + " não encontrada");
            return new ResponseEntity(new CustomErrorType("Conta de id " + id + " não encontrada"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Conta>(conta, HttpStatus.OK);
    }

    @RequestMapping(value = "/conta", method = RequestMethod.POST)
    public ResponseEntity<?> createConta(@RequestBody Conta conta) {
        logger.info("Cadastrando uma nova Conta : " + conta);

        if (contaService.isContaExist(conta)) {
            logger.error("Não foi possível cadastrar esta conta. Já existe uma Conta com o nome: " + conta.getNome());
            return new ResponseEntity(new CustomErrorType("Não foi possível cadastrar esta conta. Já existe uma Conta com o nome: " + conta.getNome()),HttpStatus.CONFLICT);
        }
        conta.setDataCriacao(new Date());
        contaService.saveConta(conta);

        return new ResponseEntity<Conta>(conta, HttpStatus.OK);
    }

    @RequestMapping(value = "/conta/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateConta(@PathVariable("id") long id, @RequestBody Conta conta) {
        logger.info("Atualizando a Conta de ID: " + id);

        Conta currentConta = contaService.findById(id);

        if (currentConta == null) {
            logger.error("Não foi possível atualizar esta conta. Conta com o ID " + id + " não localizada");
            return new ResponseEntity(new CustomErrorType("Não foi possível atualizar esta conta. Conta com o ID " + id + " não localizada"), HttpStatus.NOT_FOUND);
        }

        contaService.updateConta(conta);
        return new ResponseEntity<Conta>(conta, HttpStatus.OK);
    }

    @RequestMapping(value = "/conta/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteConta(@PathVariable("id") long id) {
        logger.info("Deletando a Conta de ID: " + id);

        Conta conta = contaService.findById(id);
        if (conta == null) {
            logger.error("Não foi possível deletar esta conta. Conta com o ID " + id + " não localizada");
            return new ResponseEntity(new CustomErrorType("Não foi possível deletar esta conta. Conta com o ID " + id + " não localizada"), HttpStatus.NOT_FOUND);
        }
        contaService.deleteContaById(id);
        return new ResponseEntity<Conta>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/conta/", method = RequestMethod.DELETE)
    public ResponseEntity<Conta> deleteAllContas() {
        logger.info("Deletando todas as Contas");

        contaService.deleteAllContas();
        return new ResponseEntity<Conta>(HttpStatus.NO_CONTENT);
    }

}