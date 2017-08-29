package br.com.erudio.repositories;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.erudio.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

    Conta findByNome(String name);
    
    @Modifying
    @Query("update Conta c set c.saldo = ?1 where c.id = ?2")
    void updateSaldo(BigDecimal novoSaldo, Long id);

}