package hr.infomare.cop.db;

import java.io.Serializable;

public class ZaposlPK implements Serializable {
    public int obrid;
    public int rbr;

    public ZaposlPK() {
    }

    public ZaposlPK(int obrid, int rbr) {
        this.obrid = obrid;
        this.rbr = rbr;
    }

    public boolean equals(Object other) {
        if (other instanceof ZaposlPK) {
            final ZaposlPK otherZaposlPK = (ZaposlPK) other;
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
}
