package br.com.erudio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.erudio.model.StatusConta;
import br.com.erudio.repositories.StatusContaRepository;
import br.com.erudio.service.StatusContaService;

@Service("statusContaService")
@Transactional
public class StatusContaServiceImpl implements StatusContaService{

    @Autowired
    private StatusContaRepository statusContaRepository;

    @Override
    public List<StatusConta> findAllStatusConta() {
        return statusContaRepository.findAll();
    }
}
