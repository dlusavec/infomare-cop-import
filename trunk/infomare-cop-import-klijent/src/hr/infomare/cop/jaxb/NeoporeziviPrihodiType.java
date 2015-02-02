
package hr.infomare.cop.jaxb;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Tip za neoporezive prihode.
 * 
 * <p>Java class for neoporeziviPrihodiType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="neoporeziviPrihodiType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="elementPlace" type="{http://www.fina.hr/cop/opobrazac/v0.6}elementPlace"/>
 *         &lt;element name="brSati" type="{http://www.fina.hr/cop/opobrazac/v0.6}brSatiType" minOccurs="0"/>
 *         &lt;element name="iznos" type="{http://www.fina.hr/cop/opobrazac/v0.6}iznosType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "neoporeziviPrihodiType", propOrder = {
    "elementPlace",
    "brSati",
    "iznos"
})
public class NeoporeziviPrihodiType {

    @XmlElement(required = true)
    protected ElementPlace elementPlace;
    protected BigDecimal brSati;
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
     * Gets the value of the brSati property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBrSati() {
        return brSati;
    }

    /**
     * Sets the value of the brSati property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBrSati(BigDecimal value) {
        this.brSati = value;
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
