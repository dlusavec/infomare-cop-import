package hr.infomare.cop.db;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "Zaposl.findAll", query = "select o from Zaposl o") })
@IdClass(ZaposlPK.class)
public class Zaposl implements Serializable {
    private static final long serialVersionUID = -2374476838603511025L;
    private String adresa;
    @Column(nullable = false)
    private Long bruto;
    @Temporal(TemporalType.DATE)
    private Date datumisp;
    @Column(nullable = false)
    private Long dohodak;
    @Column(nullable = false)
    private Long dopriz;
    @Column(nullable = false)
    private String ime;
    private String internauj;
    @Column(nullable = false)
    private Long isplata;
    private String nazivoj;
    @Column(nullable = false)
    private Long neoporez;
    @Column(nullable = false)
    private Long neto;
    @Id
    @Column(nullable = false)
    private int obrid;
    @Column(nullable = false)
    private Long obustave;
    @Column(nullable = false)
    private String oib;
    @Column(nullable = false)
    private Long olaksica;
    @Column(nullable = false)
    private Long porezosn;
    @Column(nullable = false)
    private Long poripri;
    @Column(nullable = false)
    private String prezime;
    @Column(nullable = false)
    private Long primanja;
    @Id
    @Column(nullable = false)
    private int rbr;
    @Column(nullable = false)
    private Long trosakpl;

    public Zaposl() {
    }

    public Zaposl(String adresa, Long bruto, Date datumisp, Long dohodak, Long dopriz, String ime, String internauj,
                  Long isplata, String nazivoj, Long neoporez, Long neto, int obrid, Long obustave, String oib,
                  Long olaksica, Long porezosn, Long poripri, String prezime, Long primanja, int rbr, Long trosakpl) {
        this.adresa = adresa;
        this.bruto = bruto;
        this.datumisp = datumisp;
        this.dohodak = dohodak;
        this.dopriz = dopriz;
        this.ime = ime;
        this.internauj = internauj;
        this.isplata = isplata;
        this.nazivoj = nazivoj;
        this.neoporez = neoporez;
        this.neto = neto;
        this.obrid = obrid;
        this.obustave = obustave;
        this.oib = oib;
        this.olaksica = olaksica;
        this.porezosn = porezosn;
        this.poripri = poripri;
        this.prezime = prezime;
        this.primanja = primanja;
        this.rbr = rbr;
        this.trosakpl = trosakpl;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Long getBruto() {
        return bruto;
    }

    public void setBruto(Long bruto) {
        this.bruto = bruto;
    }

    public Date getDatumisp() {
        return datumisp;
    }

    public void setDatumisp(Date datumisp) {
        this.datumisp = datumisp;
    }

    public Long getDohodak() {
        return dohodak;
    }

    public void setDohodak(Long dohodak) {
        this.dohodak = dohodak;
    }

    public Long getDopriz() {
        return dopriz;
    }

    public void setDopriz(Long dopriz) {
        this.dopriz = dopriz;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getInternauj() {
        return internauj;
    }

    public void setInternauj(String internauj) {
        this.internauj = internauj;
    }

    public Long getIsplata() {
        return isplata;
    }

    public void setIsplata(Long isplata) {
        this.isplata = isplata;
    }

    public String getNazivoj() {
        return nazivoj;
    }

    public void setNazivoj(String nazivoj) {
        this.nazivoj = nazivoj;
    }

    public Long getNeoporez() {
        return neoporez;
    }

    public void setNeoporez(Long neoporez) {
        this.neoporez = neoporez;
    }

    public Long getNeto() {
        return neto;
    }

    public void setNeto(Long neto) {
        this.neto = neto;
    }

    public int getObrid() {
        return obrid;
    }

    public void setObrid(int obrid) {
        this.obrid = obrid;
    }

    public Long getObustave() {
        return obustave;
    }

    public void setObustave(Long obustave) {
        this.obustave = obustave;
    }

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public Long getOlaksica() {
        return olaksica;
    }

    public void setOlaksica(Long olaksica) {
        this.olaksica = olaksica;
    }

    public Long getPorezosn() {
        return porezosn;
    }

    public void setPorezosn(Long porezosn) {
        this.porezosn = porezosn;
    }

    public Long getPoripri() {
        return poripri;
    }

    public void setPoripri(Long poripri) {
        this.poripri = poripri;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Long getPrimanja() {
        return primanja;
    }

    public void setPrimanja(Long primanja) {
        this.primanja = primanja;
    }

    public int getRbr() {
        return rbr;
    }

    public void setRbr(int rbr) {
        this.rbr = rbr;
    }

    public Long getTrosakpl() {
        return trosakpl;
    }

    public void setTrosakpl(Long trosakpl) {
        this.trosakpl = trosakpl;
    }
}
