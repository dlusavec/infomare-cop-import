package hr.infomare.cop.db;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "Poduzece.findAll", query = "select o from Poduzece o") })
public class Poduzece implements Serializable {
    private static final long serialVersionUID = -6879717503509118984L;
    @Column(nullable = false)
    private String adresa;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date datumobr;
    @Column(nullable = false)
    private Integer fondsati;
    @Column(nullable = false)
    private String isplata;
    @Column(nullable = false)
    private String naziv;
    @Id
    @Column(nullable = false)
    private int obrid;
    @Column(nullable = false)
    private String oib;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date perioddo;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date periodod;
    private String racunisp;

    public Poduzece() {
    }

    public Poduzece(String adresa, Date datumobr, Integer fondsati, String isplata, String naziv, int obrid, String oib,
                    Date perioddo, Date periodod, String racunisp) {
        this.adresa = adresa;
        this.datumobr = datumobr;
        this.fondsati = fondsati;
        this.isplata = isplata;
        this.naziv = naziv;
        this.obrid = obrid;
        this.oib = oib;
        this.perioddo = perioddo;
        this.periodod = periodod;
        this.racunisp = racunisp;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Date getDatumobr() {
        return datumobr;
    }

    public void setDatumobr(Date datumobr) {
        this.datumobr = datumobr;
    }

    public Integer getFondsati() {
        return fondsati;
    }

    public void setFondsati(Integer fondsati) {
        this.fondsati = fondsati;
    }

    public String getIsplata() {
        return isplata;
    }

    public void setIsplata(String isplata) {
        this.isplata = isplata;
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

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public Date getPerioddo() {
        return perioddo;
    }

    public void setPerioddo(Date perioddo) {
        this.perioddo = perioddo;
    }

    public Date getPeriodod() {
        return periodod;
    }

    public void setPeriodod(Date periodod) {
        this.periodod = periodod;
    }

    public String getRacunisp() {
        return racunisp;
    }

    public void setRacunisp(String racunisp) {
        this.racunisp = racunisp;
    }
}
