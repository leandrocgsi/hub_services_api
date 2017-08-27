package br.com.erudio.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "conta")
public class Conta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "data_criacao")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCriacao;

    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Column(name = "saldo", nullable = false)
    private BigDecimal saldo;
    
    @ManyToOne(optional=false)
    @JoinColumn(name = "idTipoConta", referencedColumnName="id", foreignKey = @ForeignKey(name = "ContaTipoConta"))
    private TipoConta tipoConta;
    
    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="id_conta_matriz", foreignKey = @ForeignKey(name = "ContaContaMatriz"))
    private Conta contaMatriz;
    
    @OneToMany(mappedBy="contaMatriz")
    private List<Conta> contasFilial = new ArrayList<Conta>();

    public Conta() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Conta getContaMatriz() {
        return contaMatriz;
    }

    public void setContaMatriz(Conta contaMatriz) {
        this.contaMatriz = contaMatriz;
    }

    public List<Conta> getContasFilial() {
        return contasFilial;
    }

    public void setContasFilial(List<Conta> contasFilial) {
        this.contasFilial = contasFilial;
    }
    
    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((contaMatriz == null) ? 0 : contaMatriz.hashCode());
        result = prime * result + ((contasFilial == null) ? 0 : contasFilial.hashCode());
        result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((saldo == null) ? 0 : saldo.hashCode());
        result = prime * result + ((tipoConta == null) ? 0 : tipoConta.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Conta other = (Conta) obj;
        if (contaMatriz == null) {
            if (other.contaMatriz != null) return false;
        } else if (!contaMatriz.equals(other.contaMatriz)) return false;
        if (contasFilial == null) {
            if (other.contasFilial != null) return false;
        } else if (!contasFilial.equals(other.contasFilial)) return false;
        if (dataCriacao == null) {
            if (other.dataCriacao != null) return false;
        } else if (!dataCriacao.equals(other.dataCriacao)) return false;
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;
        if (nome == null) {
            if (other.nome != null) return false;
        } else if (!nome.equals(other.nome)) return false;
        if (saldo == null) {
            if (other.saldo != null) return false;
        } else if (!saldo.equals(other.saldo)) return false;
        if (tipoConta == null) {
            if (other.tipoConta != null) return false;
        } else if (!tipoConta.equals(other.tipoConta)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Conta [id=" + id + ", dataCriacao=" + dataCriacao + ", nome=" + nome + ", saldo=" + saldo
               + ", tipoConta=" + tipoConta + ", contaMatriz=" + contaMatriz + ", contasFilial=" + contasFilial + "]";
    }
}