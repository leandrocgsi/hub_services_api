package br.com.erudio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.erudio.model.TipoConta;

@Repository
public interface TipoContaRepository extends JpaRepository<TipoConta, Long> {
}