package hr.infomare.cop.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = "Poripri.findAll", query = "select o from Poripri o") })
@IdClass(PoripriPK.class)
public class Poripri implements Serializable {
    private static final long serialVersionUID = 8441816372019624470L;
    @Column(nullable = false)
    private Long iznos;
    @Column(nullable = false)
    private String naziv;
    @Id
    @Column(nullable = false)
    private int obrid;
    @Column(nullable = false)
    private Long osnovica;
    @Column(nullable = false)
    private int porilipri;
    @Column(nullable = false)
    private String prirez;
    @Id
    @Column(nullable = false)
    private int rbr;
    @Column(nullable = false)
    private Long stopa;
    @Id
    @Column(nullable = false)
    private int stv;

    public Poripri() {
    }

    public Poripri(Long iznos, String naziv, int obrid, Long osnovica, int porilipri, String prirez, int rbr,
                   Long stopa, int stv) {
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

    public Long getIznos() {
        return iznos;
    }

    public void setIznos(Long iznos) {
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

    public Long getOsnovica() {
        return osnovica;
    }

    public void setOsnovica(Long osnovica) {
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

    public Long getStopa() {
        return stopa;
    }

    public void setStopa(Long stopa) {
        this.stopa = stopa;
    }

    public int getStv() {
        return stv;
    }

    public void setStv(int stv) {
        this.stv = stv;
    }
}
