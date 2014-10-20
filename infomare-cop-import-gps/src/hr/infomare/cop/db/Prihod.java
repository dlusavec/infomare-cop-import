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
@NamedQueries({ @NamedQuery(name = "Prihod.findAll", query = "select o from Prihod o") })
@IdClass(PrihodPK.class)
@Table(schema = "DBO", name = "FKCOPPRIHOD")
public class Prihod implements Serializable {
    private static final long serialVersionUID = -1230276821269286219L;
    private String internauj;
    @Column(nullable = false)
    private BigDecimal iznos;
    private BigDecimal koef;
    @Column(nullable = false)
    private String naziv;
    private String nazivuj;
    @Column(nullable = false)
    private String neoporez;
    @Id
    @Column(nullable = false)
    private int obrid;
    private BigDecimal osnovica;
    @Column(nullable = false)
    private int prihod;
    @Id
    @Column(nullable = false)
    private int rbr;
    private BigDecimal sati;
    @Id
    @Column(nullable = false)
    private int stv;

    public Prihod() {
    }

    public Prihod(String internauj, BigDecimal iznos, BigDecimal koef, String naziv, String nazivuj, String neoporez, int obrid,
                  BigDecimal osnovica, int prihod, int rbr, BigDecimal sati, int stv) {
        this.internauj = internauj;
        this.iznos = iznos;
        this.koef = koef;
        this.naziv = naziv;
        this.nazivuj = nazivuj;
        this.neoporez = neoporez;
        this.obrid = obrid;
        this.osnovica = osnovica;
        this.prihod = prihod;
        this.rbr = rbr;
        this.sati = sati;
        this.stv = stv;
    }

    public String getInternauj() {
        return internauj;
    }

    public void setInternauj(String internauj) {
        this.internauj = internauj;
    }

    public BigDecimal getIznos() {
        return iznos;
    }

    public void setIznos(BigDecimal iznos) {
        this.iznos = iznos;
    }

    public BigDecimal getKoef() {
        return koef;
    }

    public void setKoef(BigDecimal koef) {
        this.koef = koef;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getNazivuj() {
        return nazivuj;
    }

    public void setNazivuj(String nazivuj) {
        this.nazivuj = nazivuj;
    }

    public String getNeoporez() {
        return neoporez;
    }

    public void setNeoporez(String neoporez) {
        this.neoporez = neoporez;
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

    public int getPrihod() {
        return prihod;
    }

    public void setPrihod(int prihod) {
        this.prihod = prihod;
    }

    public int getRbr() {
        return rbr;
    }

    public void setRbr(int rbr) {
        this.rbr = rbr;
    }

    public BigDecimal getSati() {
        return sati;
    }

    public void setSati(BigDecimal sati) {
        this.sati = sati;
    }

    public int getStv() {
        return stv;
    }

    public void setStv(int stv) {
        this.stv = stv;
    }
}
