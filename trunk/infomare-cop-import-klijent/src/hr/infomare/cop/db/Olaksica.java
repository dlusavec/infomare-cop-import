package hr.infomare.cop.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = "Olaksica.findAll", query = "select o from Olaksica o") })
@IdClass(OlaksicaPK.class)
public class Olaksica implements Serializable {
    private static final long serialVersionUID = -1402920073306529068L;
    @Column(nullable = false)
    private Long iznos;
    @Column(nullable = false)
    private Long koeficijent;
    @Column(nullable = false)
    private String naziv;
    @Id
    @Column(nullable = false)
    private int obrid;
    @Column(nullable = false)
    private int olaksica;
    @Id
    @Column(nullable = false)
    private int rbr;
    @Id
    @Column(nullable = false)
    private int stv;

    public Olaksica() {
    }

    public Olaksica(Long iznos, Long koeficijent, String naziv, int obrid, int olaksica, int rbr, int stv) {
        this.iznos = iznos;
        this.koeficijent = koeficijent;
        this.naziv = naziv;
        this.obrid = obrid;
        this.olaksica = olaksica;
        this.rbr = rbr;
        this.stv = stv;
    }

    public Long getIznos() {
        return iznos;
    }

    public void setIznos(Long iznos) {
        this.iznos = iznos;
    }

    public Long getKoeficijent() {
        return koeficijent;
    }

    public void setKoeficijent(Long koeficijent) {
        this.koeficijent = koeficijent;
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

    public int getOlaksica() {
        return olaksica;
    }

    public void setOlaksica(int olaksica) {
        this.olaksica = olaksica;
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
