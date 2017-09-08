package br.com.erudio.controller;

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

import br.com.erudio.model.PessoaFisica;
import br.com.erudio.service.PessoaFisicaService;
import br.com.erudio.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class PessoaFisicaController {

    public static final Logger logger = LoggerFactory.getLogger(PessoaFisicaController.class);

    @Autowired
    PessoaFisicaService pessoaFisicaService;

    @RequestMapping(value = "/pessoaFisica/", method = RequestMethod.GET)
    public ResponseEntity<List<PessoaFisica>> listAllPessoaFisicas() {
        List<PessoaFisica> pessoaFisicas = pessoaFisicaService.findAllPessoaFisicas();
        if (pessoaFisicas.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<PessoaFisica>>(pessoaFisicas, HttpStatus.OK);
    }

    @RequestMapping(value = "/pessoaFisica/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getPessoaFisica(@PathVariable("id") long id) {
        logger.info("Recuperando Pessoa Fisica de ID " + id);
        PessoaFisica pessoaFisica = pessoaFisicaService.findById(id);
        if (pessoaFisica == null) {
            logger.error("Pessoa Fisica de id " + id + " não encontrada");
            return new ResponseEntity(new CustomErrorType("Pessoa Fisica de id " + id + " não encontrada"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PessoaFisica>(pessoaFisica, HttpStatus.OK);
    }

    @RequestMapping(value = "/pessoaFisica", method = RequestMethod.POST)
    public ResponseEntity<?> createPessoaFisica(@RequestBody PessoaFisica pessoaFisica) {
        logger.info("Cadastrando uma nova Pessoa Fisica : " + pessoaFisica);

        if (pessoaFisicaService.isPessoaFisicaExist(pessoaFisica)) {
            logger.error("Não foi possível cadastrar esta pessoa. Já existe uma Pessoa Fisica com o nome: " + pessoaFisica.getNomeNomeFantasia());
            return new ResponseEntity(new CustomErrorType("Não foi possível cadastrar esta pessoa. Já existe uma Pessoa Fisica com o nome: " + pessoaFisica.getNomeNomeFantasia()),HttpStatus.CONFLICT);
        }
        pessoaFisicaService.savePessoaFisica(pessoaFisica);

        return new ResponseEntity<PessoaFisica>(pessoaFisica, HttpStatus.OK);
    }

    @RequestMapping(value = "/pessoaFisica/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePessoaFisica(@PathVariable("id") long id, @RequestBody PessoaFisica pessoaFisica) {
        logger.info("Atualizando a Pessoa Fisica de ID: " + id);

        PessoaFisica currentPessoaFisica = pessoaFisicaService.findById(id);

        if (currentPessoaFisica == null) {
            logger.error("Não foi possível atualizar esta pessoa. Pessoa Fisica com o ID " + id + " não localizada");
            return new ResponseEntity(new CustomErrorType("Não foi possível atualizar esta pessoa. Pessoa Fisica com o ID " + id + " não localizada"), HttpStatus.NOT_FOUND);
        }

        pessoaFisicaService.updatePessoaFisica(pessoaFisica);
        return new ResponseEntity<PessoaFisica>(pessoaFisica, HttpStatus.OK);
    }

    @RequestMapping(value = "/pessoaFisica/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePessoaFisica(@PathVariable("id") long id) {
        logger.info("Deletando a Pessoa Fisica de ID: " + id);

        PessoaFisica pessoaFisica = pessoaFisicaService.findById(id);
        if (pessoaFisica == null) {
            logger.error("Não foi possível deletar esta pessoa. Pessoa Fisica com o ID " + id + " não localizada");
            return new ResponseEntity(new CustomErrorType("Não foi possível deletar esta pessoa. Pessoa Fisica com o ID " + id + " não localizada"), HttpStatus.NOT_FOUND);
        }
        pessoaFisicaService.deletePessoaFisicaById(id);
        return new ResponseEntity<PessoaFisica>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/pessoaFisica/", method = RequestMethod.DELETE)
    public ResponseEntity<PessoaFisica> deleteAllPessoaFisicas() {
        logger.info("Deletando todas as Pessoa Fisicas");

        pessoaFisicaService.deleteAllPessoaFisicas();
        return new ResponseEntity<PessoaFisica>(HttpStatus.NO_CONTENT);
    }

}