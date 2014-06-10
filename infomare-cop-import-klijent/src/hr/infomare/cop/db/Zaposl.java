package hr.infomare.cop.db;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "Zaposl.findAll", query = "select o from Zaposl o") })
@IdClass(ZaposlPK.class)
@Table(schema = "COPDB")
public class Zaposl implements Serializable {
    private static final long serialVersionUID = -2374476838603511025L;
    private String adresa;
    @Column(nullable = false)
    private BigDecimal bruto;
    @Temporal(TemporalType.DATE)
    private Date datumisp;
    @Column(nullable = false)
    private BigDecimal dohodak;
    @Column(nullable = false)
    private BigDecimal dopriz;
    @Column(nullable = false)
    private String ime;
    private String internauj;
    @Column(nullable = false)
    private BigDecimal isplata;
    private String nazivoj;
    @Column(nullable = false)
    private BigDecimal neoporez;
    @Column(nullable = false)
    private BigDecimal neto;
    @Id
    @Column(nullable = false)
    private int obrid;
    @Column(nullable = false)
    private BigDecimal obustave;
    @Column(nullable = false)
    private String oib;
    @Column(nullable = false)
    private BigDecimal olaksica;
    @Column(nullable = false)
    private BigDecimal porezosn;
    @Column(nullable = false)
    private BigDecimal poripri;
    @Column(nullable = false)
    private String prezime;
    @Column(nullable = false)
    private BigDecimal primanja;
    @Id
    @Column(nullable = false)
    private int rbr;
    @Column(nullable = false)
    private BigDecimal trosakpl;

    public Zaposl() {
    }

    public Zaposl(String adresa, BigDecimal bruto, Date datumisp, BigDecimal dohodak, BigDecimal dopriz, String ime, String internauj,
                  BigDecimal isplata, String nazivoj, BigDecimal neoporez, BigDecimal neto, int obrid, BigDecimal obustave, String oib,
                  BigDecimal olaksica, BigDecimal porezosn, BigDecimal poripri, String prezime, BigDecimal primanja, int rbr, BigDecimal trosakpl) {
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

    public BigDecimal getBruto() {
        return bruto;
    }

    public void setBruto(BigDecimal bruto) {
        this.bruto = bruto;
    }

    public Date getDatumisp() {
        return datumisp;
    }

    public void setDatumisp(Date datumisp) {
        this.datumisp = datumisp;
    }

    public BigDecimal getDohodak() {
        return dohodak;
    }

    public void setDohodak(BigDecimal dohodak) {
        this.dohodak = dohodak;
    }

    public BigDecimal getDopriz() {
        return dopriz;
    }

    public void setDopriz(BigDecimal dopriz) {
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

    public BigDecimal getIsplata() {
        return isplata;
    }

    public void setIsplata(BigDecimal isplata) {
        this.isplata = isplata;
    }

    public String getNazivoj() {
        return nazivoj;
    }

    public void setNazivoj(String nazivoj) {
        this.nazivoj = nazivoj;
    }

    public BigDecimal getNeoporez() {
        return neoporez;
    }

    public void setNeoporez(BigDecimal neoporez) {
        this.neoporez = neoporez;
    }

    public BigDecimal getNeto() {
        return neto;
    }

    public void setNeto(BigDecimal neto) {
        this.neto = neto;
    }

    public int getObrid() {
        return obrid;
    }

    public void setObrid(int obrid) {
        this.obrid = obrid;
    }

    public BigDecimal getObustave() {
        return obustave;
    }

    public void setObustave(BigDecimal obustave) {
        this.obustave = obustave;
    }

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public BigDecimal getOlaksica() {
        return olaksica;
    }

    public void setOlaksica(BigDecimal olaksica) {
        this.olaksica = olaksica;
    }

    public BigDecimal getPorezosn() {
        return porezosn;
    }

    public void setPorezosn(BigDecimal porezosn) {
        this.porezosn = porezosn;
    }

    public BigDecimal getPoripri() {
        return poripri;
    }

    public void setPoripri(BigDecimal poripri) {
        this.poripri = poripri;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public BigDecimal getPrimanja() {
        return primanja;
    }

    public void setPrimanja(BigDecimal primanja) {
        this.primanja = primanja;
    }

    public int getRbr() {
        return rbr;
    }

    public void setRbr(int rbr) {
        this.rbr = rbr;
    }

    public BigDecimal getTrosakpl() {
        return trosakpl;
    }

    public void setTrosakpl(BigDecimal trosakpl) {
        this.trosakpl = trosakpl;
    }
}
