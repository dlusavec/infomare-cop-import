package hr.infomare.cop.db;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "Poripri.findAll", query = "select o from Poripri o") })
@IdClass(PoripriPK.class)
@Table(schema = "DBO", name = "FKCOPPORIPRI")
public class Poripri implements Serializable {
    private static final long serialVersionUID = 8441816372019624470L;
    @Column(nullable = false)
    private BigDecimal iznos;
    @Column(nullable = false)
    private String naziv;
    @Id
    @Column(nullable = false)
    private int obrid;
    @Column(nullable = false)
    private BigDecimal osnovica;
    @Column(nullable = false)
    private int porilipri;
    @Column(nullable = false)
    private String prirez;
    @Id
    @Column(nullable = false)
    private int rbr;
    @Column(nullable = false)
    private BigDecimal stopa;
    @Id
    @Column(nullable = false)
    private int stv;

    public Poripri() {
    }

    public Poripri(BigDecimal iznos, String naziv, int obrid, BigDecimal osnovica, int porilipri, String prirez, int rbr,
                   BigDecimal stopa, int stv) {
        this.iznos = iznos;
        this.naziv = naziv;
        this.obrid = obrid;
        this.osnovica = osnovica;
        this.porilipri = porilipri;
        this.prirez = prirez;
        this.rbr = rbr;
        this.stopa = stopa;
        this.stv = stv;
    }

    public BigDecimal getIznos() {
        return iznos;
    }

    public void setIznos(BigDecimal iznos) {
        this.iznos = iznos;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getObrid() {
        return obrid;
    }

    public void setObrid(int obrid) {
        this.obrid = obrid;
    }

    public BigDecimal getOsnovica() {
        return osnovica;
    }

    public void setOsnovica(BigDecimal osnovica) {
        this.osnovica = osnovica;
    }

    public int getPorilipri() {
        return porilipri;
    }

    public void setPorilipri(int porilipri) {
        this.porilipri = porilipri;
    }

    public String getPrirez() {
        return prirez;
    }

    public void setPrirez(String prirez) {
        this.prirez = prirez;
    }

    public int getRbr() {
        return rbr;
    }

    public void setRbr(int rbr) {
        this.rbr = rbr;
    }

    public BigDecimal getStopa() {
        return stopa;
    }

    public void setStopa(BigDecimal stopa) {
        this.stopa = stopa;
    }

    public int getStv() {
        return stv;
    }

    public void setStv(int stv) {
        this.stv = stv;
    }
}
