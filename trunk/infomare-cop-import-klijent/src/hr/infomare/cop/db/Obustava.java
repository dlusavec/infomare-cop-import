package hr.infomare.cop.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = "Obustava.findAll", query = "select o from Obustava o") })
@IdClass(ObustavaPK.class)
public class Obustava implements Serializable {
    private static final long serialVersionUID = -7572052302026979576L;
    @Column(nullable = false)
    private Long iznos;
    @Column(nullable = false)
    private String naziv;
    @Id
    @Column(nullable = false)
    private int obrid;
    @Column(nullable = false)
    private int obustava;
    @Column(nullable = false)
    private String opis;
    private Integer ostrata;
    private Long posto;
    @Id
    @Column(nullable = false)
    private int rbr;
    @Column(nullable = false)
    private Long saldo;
    @Id
    @Column(nullable = false)
    private int stv;

    public Obustava() {
    }

    public Obustava(Long iznos, String naziv, int obrid, int obustava, String opis, Integer ostrata, Long posto,
                    int rbr, Long saldo, int stv) {
        this.iznos = iznos;
        this.naziv = naziv;
        this.obrid = obrid;
        this.obustava = obustava;
        this.opis = opis;
        this.ostrata = ostrata;
        this.posto = posto;
        this.rbr = rbr;
        this.saldo = saldo;
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

    public int getObustava() {
        return obustava;
    }

    public void setObustava(int obustava) {
        this.obustava = obustava;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Integer getOstrata() {
        return ostrata;
    }

    public void setOstrata(Integer ostrata) {
        this.ostrata = ostrata;
    }

    public Long getPosto() {
        return posto;
    }

    public void setPosto(Long posto) {
        this.posto = posto;
    }

    public int getRbr() {
        return rbr;
    }

    public void setRbr(int rbr) {
        this.rbr = rbr;
    }

    public Long getSaldo() {
        return saldo;
    }

    public void setSaldo(Long saldo) {
        this.saldo = saldo;
    }

    public int getStv() {
        return stv;
    }

    public void setStv(int stv) {
        this.stv = stv;
    }
}
