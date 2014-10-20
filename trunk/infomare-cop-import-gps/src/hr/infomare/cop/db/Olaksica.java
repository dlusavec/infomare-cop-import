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
@NamedQueries({ @NamedQuery(name = "Olaksica.findAll", query = "select o from Olaksica o") })
@IdClass(OlaksicaPK.class)
@Table(schema = "DBO", name = "FKCOPOLAKSICA")
public class Olaksica implements Serializable {
    private static final long serialVersionUID = -1402920073306529068L;
    @Column(nullable = false)
    private BigDecimal iznos;
    @Column(nullable = false)
    private BigDecimal koeficijent;
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

    public Olaksica(BigDecimal iznos, BigDecimal koeficijent, String naziv, int obrid, int olaksica, int rbr, int stv) {
        this.iznos = iznos;
        this.koeficijent = koeficijent;
        this.naziv = naziv;
        this.obrid = obrid;
        this.olaksica = olaksica;
        this.rbr = rbr;
        this.stv = stv;
    }

    public BigDecimal getIznos() {
        return iznos;
    }

    public void setIznos(BigDecimal iznos) {
        this.iznos = iznos;
    }

    public BigDecimal getKoeficijent() {
        return koeficijent;
    }

    public void setKoeficijent(BigDecimal koeficijent) {
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
