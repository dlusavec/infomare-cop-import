package hr.infomare.cop.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = "Doprinos.findAll", query = "select o from Doprinos o") })
@IdClass(DoprinosPK.class)
public class Doprinos implements Serializable {
    private static final long serialVersionUID = 2215706990861538354L;
    @Column(nullable = false)
    private int doprinos;
    @Column(nullable = false)
    private Long iznos;
    @Column(nullable = false)
    private String naziv;
    @Id
    @Column(nullable = false)
    private int obrid;
    @Column(nullable = false)
    private String primjena;
    @Id
    @Column(nullable = false)
    private int rbr;
    @Column(nullable = false)
    private Long stopa;
    @Id
    @Column(nullable = false)
    private int stv;

    public Doprinos() {
    }

    public Doprinos(int doprinos, Long iznos, String naziv, int obrid, String primjena, int rbr, Long stopa, int stv) {
        this.doprinos = doprinos;
        this.iznos = iznos;
        this.naziv = naziv;
        this.obrid = obrid;
        this.primjena = primjena;
        this.rbr = rbr;
        this.stopa = stopa;
        this.stv = stv;
    }

    public int getDoprinos() {
        return doprinos;
    }

    public void setDoprinos(int doprinos) {
        this.doprinos = doprinos;
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

    public String getPrimjena() {
        return primjena;
    }

    public void setPrimjena(String primjena) {
        this.primjena = primjena;
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
