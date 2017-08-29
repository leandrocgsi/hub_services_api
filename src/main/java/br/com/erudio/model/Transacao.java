package br.com.erudio.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "transacao")
public class Transacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="id_conta_origem", referencedColumnName="id", foreignKey = @ForeignKey(name = "OrigemTransacao"))
    private Conta origem;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="id_conta_destino", referencedColumnName="id", foreignKey = @ForeignKey(name = "DestinoTransacao"))
    private Conta destino;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="id_tipo_transacao", referencedColumnName="id", foreignKey = @ForeignKey(name = "TipoTransacaoTransacao"))
    private TipoTransacao tipoTransacao;
    
    @Column(name = "data_transacao")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataTransacao;

    @Column(name = "codigo")
    private String codigo;
    
    @Column(name = "estornada")
    private Boolean estornada;
    
    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    public Transacao() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Conta getOrigem() {
        return origem;
    }

    public void setOrigem(Conta origem) {
        this.origem = origem;
    }

    public Conta getDestino() {
        return destino;
    }

    public void setDestino(Conta destino) {
        this.destino = destino;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Boolean getEstornada() {
        return estornada;
    }

    public void setEstornada(Boolean estornada) {
        this.estornada = estornada;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        result = prime * result + ((dataTransacao == null) ? 0 : dataTransacao.hashCode());
        result = prime * result + ((destino == null) ? 0 : destino.hashCode());
        result = prime * result + ((estornada == null) ? 0 : estornada.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((origem == null) ? 0 : origem.hashCode());
        result = prime * result + ((tipoTransacao == null) ? 0 : tipoTransacao.hashCode());
        result = prime * result + ((valor == null) ? 0 : valor.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Transacao other = (Transacao) obj;
        if (codigo == null) {
            if (other.codigo != null) return false;
        } else if (!codigo.equals(other.codigo)) return false;
        if (dataTransacao == null) {
            if (other.dataTransacao != null) return false;
        } else if (!dataTransacao.equals(other.dataTransacao)) return false;
        if (destino == null) {
            if (other.destino != null) return false;
        } else if (!destino.equals(other.destino)) return false;
        if (estornada == null) {
            if (other.estornada != null) return false;
        } else if (!estornada.equals(other.estornada)) return false;
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;
        if (origem == null) {
            if (other.origem != null) return false;
        } else if (!origem.equals(other.origem)) return false;
        if (tipoTransacao == null) {
            if (other.tipoTransacao != null) return false;
        } else if (!tipoTransacao.equals(other.tipoTransacao)) return false;
        if (valor == null) {
            if (other.valor != null) return false;
        } else if (!valor.equals(other.valor)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Transacao [id=" + id + ", origem=" + origem + ", destino=" + destino + ", tipoTransacao="
               + tipoTransacao + ", dataTransacao=" + dataTransacao + ", codigo=" + codigo + ", estornada=" + estornada
               + ", valor=" + valor + "]";
    }

}