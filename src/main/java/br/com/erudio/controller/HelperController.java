package br.com.erudio.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.model.Pessoa;
import br.com.erudio.model.StatusConta;
import br.com.erudio.model.TipoConta;
import br.com.erudio.service.PessoaService;
import br.com.erudio.service.StatusContaService;
import br.com.erudio.service.TipoContaService;

@RestController
@RequestMapping("/api")
public class HelperController {

    public static final Logger logger = LoggerFactory.getLogger(HelperController.class);

    @Autowired
    TipoContaService tipoContaService;
    
    @Autowired
    StatusContaService StatusContaService;
    
    @Autowired
    PessoaService pessoaService;

    @RequestMapping(value = "/helper/tiposConta", method = RequestMethod.GET)
    public ResponseEntity<List<TipoConta>> listAllTipoContas() {
        List<TipoConta> tiposConta = tipoContaService.findAllTipoConta();
        if (tiposConta.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<TipoConta>>(tiposConta, HttpStatus.OK);
    }

    @RequestMapping(value = "/helper/statusConta", method = RequestMethod.GET)
    public ResponseEntity<List<StatusConta>> listAllStatusContas() {
        List<StatusConta> statusConta = StatusContaService.findAllStatusConta();
        if (statusConta.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<StatusConta>>(statusConta, HttpStatus.OK);
    }

    @RequestMapping(value = "/helper/pessoas", method = RequestMethod.GET)
    public ResponseEntity<List<Pessoa>> listAllPessoas() {
        List<Pessoa> pessoa = pessoaService.findAllPessoa();
        if (pessoa.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<Pessoa>>(pessoa, HttpStatus.OK);
    }
}