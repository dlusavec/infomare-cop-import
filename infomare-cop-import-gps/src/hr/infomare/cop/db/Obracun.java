package hr.infomare.cop.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "Obracun.findAll", query = "select o from Obracun o") })
@Table(schema = "COPDB")
public class Obracun implements Serializable {
    private static final long serialVersionUID = 7664925003666898483L;
    private Integer k50god;
    private Integer k50nal;
    @Id
    @Column(nullable = false)
    private int obrid;
    @Column(nullable = false)
    private Integer status;

    public Obracun() {
    }

    public Obracun(Integer k50god, Integer k50nal, int obrid, Integer status) {
        this.k50god = k50god;
        this.k50nal = k50nal;
        this.obrid = obrid;
        this.status = status;
    }

    public Integer getK50god() {
        return k50god;
    }

    public void setK50god(Integer k50god) {
        this.k50god = k50god;
    }

    public Integer getK50nal() {
        return k50nal;
    }

    public void setK50nal(Integer k50nal) {
        this.k50nal = k50nal;
    }

    public int getObrid() {
        return obrid;
    }

    public void setObrid(int obrid) {
        this.obrid = obrid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
