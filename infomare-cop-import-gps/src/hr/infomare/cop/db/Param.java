package hr.infomare.cop.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "Param.findAll", query = "select o from Param o") })
@IdClass(ParamPK.class)
@Table(schema = "DBO", name = "FKCOPPARAM")
public class Param implements Serializable {
    private static final long serialVersionUID = 3204663152931666863L;
    @Column(nullable = false)
    private String datumdo;
    @Column(nullable = false)
    private String datumod;
    @Id
    @Column(nullable = false)
    private int obrid;
    private String opis;
    @Column(nullable = false)
    private String parametar;
    @Id
    @Column(nullable = false)
    private int rbr;
    @Id
    @Column(nullable = false)
    private int stv;

    public Param() {
    }

    public Param(String datumdo, String datumod, int obrid, String opis, String parametar, int rbr, int stv) {
        this.datumdo = datumdo;
        this.datumod = datumod;
        this.obrid = obrid;
        this.opis = opis;
        this.parametar = parametar;
        this.rbr = rbr;
        this.stv = stv;
    }

    public String getDatumdo() {
        return datumdo;
    }

    public void setDatumdo(String datumdo) {
        this.datumdo = datumdo;
    }

    public String getDatumod() {
        return datumod;
    }

    public void setDatumod(String datumod) {
        this.datumod = datumod;
    }

    public int getObrid() {
        return obrid;
    }

    public void setObrid(int obrid) {
        this.obrid = obrid;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getParametar() {
        return parametar;
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
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
