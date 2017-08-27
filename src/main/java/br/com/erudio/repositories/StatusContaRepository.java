package br.com.erudio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.erudio.model.StatusConta;

@Repository
public interface StatusContaRepository extends JpaRepository<StatusConta, Long> {
}