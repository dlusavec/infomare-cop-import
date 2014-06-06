package hr.infomare.cop.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = "Prihod.findAll", query = "select o from Prihod o") })
@IdClass(PrihodPK.class)
public class Prihod implements Serializable {
    private static final long serialVersionUID = -1230276821269286219L;
    private String internauj;
    @Column(nullable = false)
    private Long iznos;
    private Long koef;
    @Column(nullable = false)
    private String naziv;
    private String nazivuj;
    @Column(nullable = false)
    private String neoporez;
    @Id
    @Column(nullable = false)
    private int obrid;
    private Long osnovica;
    @Column(nullable = false)
    private int prihod;
    @Id
    @Column(nullable = false)
    private int rbr;
    private Long sati;
    @Id
    @Column(nullable = false)
    private int stv;

    public Prihod() {
    }

    public Prihod(String internauj, Long iznos, Long koef, String naziv, String nazivuj, String neoporez, int obrid,
                  Long osnovica, int prihod, int rbr, Long sati, int stv) {
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

    public Long getIznos() {
        return iznos;
    }

    public void setIznos(Long iznos) {
        this.iznos = iznos;
    }

    public Long getKoef() {
        return koef;
    }

    public void setKoef(Long koef) {
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

    public Long getOsnovica() {
        return osnovica;
    }

    public void setOsnovica(Long osnovica) {
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

    public Long getSati() {
        return sati;
    }

    public void setSati(Long sati) {
        this.sati = sati;
    }

    public int getStv() {
        return stv;
    }

    public void setStv(int stv) {
        this.stv = stv;
    }
}
