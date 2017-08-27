package br.com.erudio.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "J")
public class PessoaJuridica extends Pessoa {

    private static final long serialVersionUID = 1L;
    
    @Column (name="NomeRazaoSocial")
    private String nomeRazaoSocial;
    
    public PessoaJuridica() {
//        this.tipoaluno = new Tipo();
//        this.turno = new Turno();
    }

    public String getNomeRazaoSocial() {
        return nomeRazaoSocial;
    }

    public void setNomeRazaoSocial(String nomeRazaoSocial) {
        this.nomeRazaoSocial = nomeRazaoSocial;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nomeRazaoSocial == null) ? 0 : nomeRazaoSocial.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        PessoaJuridica other = (PessoaJuridica) obj;
        if (nomeRazaoSocial == null) {
            if (other.nomeRazaoSocial != null) return false;
        } else if (!nomeRazaoSocial.equals(other.nomeRazaoSocial)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "PessoaJuridica [nomeRazaoSocial=" + nomeRazaoSocial + "]";
    }
}