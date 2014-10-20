package hr.infomare.cop.db;

import java.io.Serializable;

public class ZapracPK implements Serializable {
    public int obrid;
    public int rbr;
    public int stv;

    public ZapracPK() {
    }

    public ZapracPK(int obrid, int rbr, int stv) {
        this.obrid = obrid;
        this.rbr = rbr;
        this.stv = stv;
    }

    public boolean equals(Object other) {
        if (other instanceof ZapracPK) {
            final ZapracPK otherZapracPK = (ZapracPK) other;
            final boolean areEqual = true;
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public int getObrid() {
        return obrid;
    }

    public void setObrid(int obrid) {
        this.obrid = obrid;
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
