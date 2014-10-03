
package hr.infomare.cop.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="poslodavac" type="{http://www.fina.hr/cop/opobrazac/v0.5}institucijaType"/>
 *         &lt;element name="zaposlenik" type="{http://www.fina.hr/cop/opobrazac/v0.5}zaposlenikType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "poslodavac", "zaposlenik" })
@XmlRootElement(name = "opObrasci")
public class OpObrasci {

    @XmlElement(required = true)
    protected InstitucijaType poslodavac;
    @XmlElement(required = true)
    protected List<ZaposlenikType> zaposlenik;

    /**
     * Gets the value of the poslodavac property.
     *
     * @return
     *     possible object is
     *     {@link InstitucijaType }
     *
     */
    public InstitucijaType getPoslodavac() {
        return poslodavac;
    }

    /**
     * Sets the value of the poslodavac property.
     *
     * @param value
     *     allowed object is
     *     {@link InstitucijaType }
     *
     */
    public void setPoslodavac(InstitucijaType value) {
        this.poslodavac = value;
    }

    /**
     * Gets the value of the zaposlenik property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zaposlenik property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZaposlenik().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ZaposlenikType }
     *
     *
     */
    public List<ZaposlenikType> getZaposlenik() {
        if (zaposlenik == null) {
            zaposlenik = new ArrayList<ZaposlenikType>();
        }
        return this.zaposlenik;
    }

}
