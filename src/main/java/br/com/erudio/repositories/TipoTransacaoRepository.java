package br.com.erudio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.erudio.model.TipoTransacao;

@Repository
public interface TipoTransacaoRepository extends JpaRepository<TipoTransacao, Long> {
}