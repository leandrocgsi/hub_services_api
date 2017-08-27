package br.com.erudio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.erudio.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

    Conta findByNome(String name);

}