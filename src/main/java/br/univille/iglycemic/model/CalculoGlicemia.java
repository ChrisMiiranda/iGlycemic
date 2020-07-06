package br.univille.iglycemic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CalculoGlicemia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int totalGlic;
    private int alvoGlic;
    @Column(nullable = false)
    private int fatorSens;
    private int totalInsu;

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public int getTotalGlic() {
        return totalGlic;
    }

    public void setTotalGlic(final int totalGlic) {
        this.totalGlic = totalGlic;
    }

    public int getAlvoGlic() {
        return alvoGlic;
    }

    public void setAlvoGlic(final int alvoGlic) {
        this.alvoGlic = alvoGlic;
    }
    
    public int getFatorSens() {
        return fatorSens;
    }

    public void setFatorSens(final int fatorSens) {
        this.fatorSens = fatorSens;
    }

    public int getTotalInsu() {
        return totalInsu;
    }
    
    public void setTotalInsu(final int totalInsu) {
        this.totalInsu = totalInsu;
    }

}