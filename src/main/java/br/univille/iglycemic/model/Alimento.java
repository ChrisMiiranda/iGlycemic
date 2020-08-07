package br.univille.iglycemic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Alimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 200)
    private String nomeAlimento;
    private String proporcao;
    private double valorCarb;
    private double medida;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public String getNomeAlimento() {
        return nomeAlimento;
    }

    public void setNomeAlimento(String nomeAlimento) {
        this.nomeAlimento = nomeAlimento;
    }
    
    public String getProporcao() {
        return proporcao;
    }

    public void setProporcao(String proporcao) {
        this.proporcao = proporcao;
    }
    
    public double getValorCarb() {
        return valorCarb;
    }

    public void setValorCarb(double valorCarb) {
        this.valorCarb = valorCarb;
    }
    
    public double getMedida() {
        return medida;
    }
    
    public void setMedida(double medida) {
        this.medida = medida;
    }

}