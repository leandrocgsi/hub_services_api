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

import br.com.erudio.model.PessoaJuridica;
import br.com.erudio.service.PessoaJuridicaService;
import br.com.erudio.util.CustomErrorType;

@SuppressWarnings({ "rawtypes", "unchecked" })
@RestController
@RequestMapping("/api")
public class PessoaJuridicaController {

    public static final Logger logger = LoggerFactory.getLogger(PessoaJuridicaController.class);

    @Autowired
    PessoaJuridicaService pessoaJuridicaService;

    @RequestMapping(value = "/pessoaJuridica/", method = RequestMethod.GET)
    public ResponseEntity<List<PessoaJuridica>> listAllPessoaJuridicas() {
        List<PessoaJuridica> pessoaJuridicas = pessoaJuridicaService.findAllPessoaJuridicas();
        if (pessoaJuridicas.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<PessoaJuridica>>(pessoaJuridicas, HttpStatus.OK);
    }

    @RequestMapping(value = "/pessoaJuridica/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getPessoaJuridica(@PathVariable("id") long id) {
        logger.info("Recuperando Pessoa Juridica de ID " + id);
        PessoaJuridica pessoaJuridica = pessoaJuridicaService.findById(id);
        if (pessoaJuridica == null) {
            logger.error("Pessoa Juridica de id " + id + " não encontrada");
            return new ResponseEntity(new CustomErrorType("Pessoa Juridica de id " + id + " não encontrada"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PessoaJuridica>(pessoaJuridica, HttpStatus.OK);
    }

    @RequestMapping(value = "/pessoaJuridica", method = RequestMethod.POST)
    public ResponseEntity<?> createPessoaJuridica(@RequestBody PessoaJuridica pessoaJuridica) {
        logger.info("Cadastrando uma nova Pessoa Juridica : " + pessoaJuridica);

        if (pessoaJuridicaService.isPessoaJuridicaExist(pessoaJuridica)) {
            logger.error("Não foi possível cadastrar esta pessoa. Já existe uma Pessoa Juridica com o nome: " + pessoaJuridica.getNomeNomeFantasia());
            return new ResponseEntity(new CustomErrorType("Não foi possível cadastrar esta pessoa. Já existe uma Pessoa Juridica com o nome: " + pessoaJuridica.getNomeNomeFantasia()),HttpStatus.CONFLICT);
        }
        pessoaJuridicaService.savePessoaJuridica(pessoaJuridica);

        return new ResponseEntity<PessoaJuridica>(pessoaJuridica, HttpStatus.OK);
    }

    @RequestMapping(value = "/pessoaJuridica", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePessoaJuridica(@RequestBody PessoaJuridica pessoaJuridica) {
        return updatePessoaJuridica(pessoaJuridica.getId(), pessoaJuridica);
    }

    @RequestMapping(value = "/pessoaJuridica/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePessoaJuridica(@PathVariable("id") long id, @RequestBody PessoaJuridica pessoaJuridica) {
        logger.info("Atualizando a Pessoa Juridica de ID: " + id);

        PessoaJuridica currentPessoaJuridica = pessoaJuridicaService.findById(id);

        if (currentPessoaJuridica == null) {
            logger.error("Não foi possível atualizar esta pessoa. Pessoa Juridica com o ID " + id + " não localizada");
            return new ResponseEntity(new CustomErrorType("Não foi possível atualizar esta pessoa. Pessoa Juridica com o ID " + id + " não localizada"), HttpStatus.NOT_FOUND);
        }


        pessoaJuridicaService.updatePessoaJuridica(pessoaJuridica);
        return new ResponseEntity<PessoaJuridica>(pessoaJuridica, HttpStatus.OK);
    }

    @RequestMapping(value = "/pessoaJuridica/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePessoaJuridica(@PathVariable("id") long id) {
        logger.info("Deletando a Pessoa Juridica de ID: " + id);

        PessoaJuridica pessoaJuridica = pessoaJuridicaService.findById(id);
        if (pessoaJuridica == null) {
            logger.error("Não foi possível deletar esta pessoa. Pessoa Juridica com o ID " + id + " não localizada");
            return new ResponseEntity(new CustomErrorType("Não foi possível deletar esta pessoa. Pessoa Juridica com o ID " + id + " não localizada"), HttpStatus.NOT_FOUND);
        }
        pessoaJuridicaService.deletePessoaJuridicaById(id);
        return new ResponseEntity<PessoaJuridica>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/pessoaJuridica/", method = RequestMethod.DELETE)
    public ResponseEntity<PessoaJuridica> deleteAllPessoaJuridicas() {
        logger.info("Deletando todas as Pessoas Juridicas");

        pessoaJuridicaService.deleteAllPessoaJuridicas();
        return new ResponseEntity<PessoaJuridica>(HttpStatus.NO_CONTENT);
    }

}
