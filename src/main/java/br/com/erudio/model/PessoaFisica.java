package br.com.erudio.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
@DiscriminatorValue(value = "F")
public class PessoaFisica extends Pessoa{

    private static final long serialVersionUID = 1L;
    
    @Column(name = "DataDeNascimento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeNascimento;
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;


    public PessoaFisica() {}

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((dataDeNascimento == null) ? 0 : dataDeNascimento.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        PessoaFisica other = (PessoaFisica) obj;
        if (dataDeNascimento == null) {
            if (other.dataDeNascimento != null) return false;
        } else if (!dataDeNascimento.equals(other.dataDeNascimento)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "PessoaFisica [dataDeNascimento=" + dataDeNascimento + "]";
    }
}