package br.com.walterrx.redis.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class BoletoDomain implements Serializable {

public static final String CACHE_NAME = "Boleto";

@Id
private String codigoBarras;
private String nomeInstituicao;
private String cpf;
private String dataVencimento;
private String valorBoleto;
private String sacado;

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getValorBoleto() {
        return valorBoleto;
    }

    public void setValorBoleto(String valorBoleto) {
        this.valorBoleto = valorBoleto;
    }

    public String getSacado() {
        return sacado;
    }

    public void setSacado(String sacado) {
        this.sacado = sacado;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoBarras, cpf, valorBoleto);
    }
}
