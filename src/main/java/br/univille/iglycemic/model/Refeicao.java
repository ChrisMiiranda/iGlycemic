package br.univille.iglycemic.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Refeicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
    private Usuario usuario;
    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
    private List<Alimento> colAlimentos = new ArrayList<>();
    private int totalCarb;
    private int fatorSens;
    private int totalInsu;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Alimento> getColAlimentos() {
        return colAlimentos;
    }

    public void setColAlimentos(List<Alimento> colAlimentos) {
        this.colAlimentos = colAlimentos;
    }

    public int getTotalCarb() {
        return totalCarb;
    }

    public void setTotalCarb(int totalCarb) {
        this.totalCarb = totalCarb;
    }

    public int getFatorSens() {
        return fatorSens;
    }

    public void setFatorSens(int fatorSens) {
        this.fatorSens = fatorSens;
    }

    public int getTotalInsu() {
        return totalInsu;
    }

    public void setTotalInsu(int totalInsu) {
        this.totalInsu = totalInsu;
    }

}