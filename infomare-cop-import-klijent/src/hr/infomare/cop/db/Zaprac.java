package hr.infomare.cop.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = "Zaprac.findAll", query = "select o from Zaprac o") })
@IdClass(ZapracPK.class)
public class Zaprac implements Serializable {
    private static final long serialVersionUID = -927155380376703878L;
    private Long iznos;
    @Id
    @Column(nullable = false)
    private int obrid;
    @Column(nullable = false)
    private String racunban;
    @Column(nullable = false)
    private String racunzap;
    @Id
    @Column(nullable = false)
    private int rbr;
    @Id
    @Column(nullable = false)
    private int stv;

    public Zaprac() {
    }

    public Zaprac(Long iznos, int obrid, String racunban, String racunzap, int rbr, int stv) {
        this.iznos = iznos;
        this.obrid = obrid;
        this.racunban = racunban;
        this.racunzap = racunzap;
        this.rbr = rbr;
        this.stv = stv;
    }

    public Long getIznos() {
        return iznos;
    }

    public void setIznos(Long iznos) {
        this.iznos = iznos;
    }

    public int getObrid() {
        return obrid;
    }

    public void setObrid(int obrid) {
        this.obrid = obrid;
    }

    public String getRacunban() {
        return racunban;
    }

    public void setRacunban(String racunban) {
        this.racunban = racunban;
    }

    public String getRacunzap() {
        return racunzap;
    }

    public void setRacunzap(String racunzap) {
        this.racunzap = racunzap;
    }

    public int getRbr() {
        return rbr;
    }

    public void setRbr(int rbr) {
        this.rbr = rbr;
    }

    public int getStv() {
        return stv;
    }

    public void setStv(int stv) {
        this.stv = stv;
    }
}
