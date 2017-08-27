package br.com.erudio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TipoPessoa", discriminatorType = DiscriminatorType.STRING)
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long id;

    @Column(name = "CPFCNPJ", length = 19, nullable = false)
    private String cpfcnpj;

    @Column(name = "NomeNomeFantasia", nullable = false)
    private String nomeNomeFantasia;

    public Pessoa() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpfcnpj() {
        return cpfcnpj;
    }

    public void setCpfcnpj(String cpfcnpj) {
        this.cpfcnpj = cpfcnpj;
    }

    public String getNomeNomeFantasia() {
        return nomeNomeFantasia;
    }

    public void setNomeNomeFantasia(String nomeNomeFantasia) {
        this.nomeNomeFantasia = nomeNomeFantasia;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpfcnpj == null) ? 0 : cpfcnpj.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nomeNomeFantasia == null) ? 0 : nomeNomeFantasia.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Pessoa other = (Pessoa) obj;
        if (cpfcnpj == null) {
            if (other.cpfcnpj != null) return false;
        } else if (!cpfcnpj.equals(other.cpfcnpj)) return false;
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;
        if (nomeNomeFantasia == null) {
            if (other.nomeNomeFantasia != null) return false;
        } else if (!nomeNomeFantasia.equals(other.nomeNomeFantasia)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Pessoa [id=" + id + ", cpfcnpj=" + cpfcnpj + ", nomeNomeFantasia=" + nomeNomeFantasia + "]";
    }
}