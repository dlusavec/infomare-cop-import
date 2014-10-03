
package hr.infomare.cop.jaxb;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Tip za porez na dohodak i prirez poreza.
 *
 * <p>Java class for porezPrirezType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="porezPrirezType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="elementPlace" type="{http://www.fina.hr/cop/opobrazac/v0.5}elementPlace"/>
 *         &lt;element name="stopa" type="{http://www.fina.hr/cop/opobrazac/v0.5}stopaType"/>
 *         &lt;element name="osnovica" type="{http://www.fina.hr/cop/opobrazac/v0.5}iznosType"/>
 *         &lt;element name="iznos" type="{http://www.fina.hr/cop/opobrazac/v0.5}iznosType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "porezPrirezType", propOrder = { "elementPlace", "stopa", "osnovica", "iznos" })
public class PorezPrirezType {

    @XmlElement(required = true)
    protected ElementPlace elementPlace;
    @XmlElement(required = true)
    protected BigDecimal stopa;
    @XmlElement(required = true)
    protected BigDecimal osnovica;
    @XmlElement(required = true)
    protected BigDecimal iznos;

    /**
     * Gets the value of the elementPlace property.
     *
     * @return
     *     possible object is
     *     {@link ElementPlace }
     *
     */
    public ElementPlace getElementPlace() {
        return elementPlace;
    }

    /**
     * Sets the value of the elementPlace property.
     *
     * @param value
     *     allowed object is
     *     {@link ElementPlace }
     *
     */
    public void setElementPlace(ElementPlace value) {
        this.elementPlace = value;
    }

    /**
     * Gets the value of the stopa property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getStopa() {
        return stopa;
    }

    /**
     * Sets the value of the stopa property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setStopa(BigDecimal value) {
        this.stopa = value;
    }

    /**
     * Gets the value of the osnovica property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getOsnovica() {
        return osnovica;
    }

    /**
     * Sets the value of the osnovica property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setOsnovica(BigDecimal value) {
        this.osnovica = value;
    }

    /**
     * Gets the value of the iznos property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getIznos() {
        return iznos;
    }

    /**
     * Sets the value of the iznos property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setIznos(BigDecimal value) {
        this.iznos = value;
    }

}
