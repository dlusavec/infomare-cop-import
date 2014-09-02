
package hr.infomare.cop.jaxb;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Tip za obustave.
 * 
 * <p>Java class for obustaveType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="obustaveType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="elementPlace" type="{http://www.fina.hr/cop/opobrazac/v0.4}elementPlace"/>
 *         &lt;element name="opisObustave">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="200"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="nazVjerovnika">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="200"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="saldo" type="{http://www.fina.hr/cop/opobrazac/v0.4}iznosType"/>
 *         &lt;element name="postotak" type="{http://www.fina.hr/cop/opobrazac/v0.4}stopaType" minOccurs="0"/>
 *         &lt;element name="brPreostalihRata" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="iznos" type="{http://www.fina.hr/cop/opobrazac/v0.4}iznosType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "obustaveType", propOrder = {
    "elementPlace",
    "opisObustave",
    "nazVjerovnika",
    "saldo",
    "postotak",
    "brPreostalihRata",
    "iznos"
})
public class ObustaveType {

    @XmlElement(required = true)
    protected ElementPlace elementPlace;
    @XmlElement(required = true)
    protected String opisObustave;
    @XmlElement(required = true)
    protected String nazVjerovnika;
    @XmlElement(required = true)
    protected BigDecimal saldo;
    protected BigDecimal postotak;
    protected Integer brPreostalihRata;
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
     * Gets the value of the opisObustave property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpisObustave() {
        return opisObustave;
    }

    /**
     * Sets the value of the opisObustave property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpisObustave(String value) {
        this.opisObustave = value;
    }

    /**
     * Gets the value of the nazVjerovnika property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNazVjerovnika() {
        return nazVjerovnika;
    }

    /**
     * Sets the value of the nazVjerovnika property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNazVjerovnika(String value) {
        this.nazVjerovnika = value;
    }

    /**
     * Gets the value of the saldo property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSaldo() {
        return saldo;
    }

    /**
     * Sets the value of the saldo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSaldo(BigDecimal value) {
        this.saldo = value;
    }

    /**
     * Gets the value of the postotak property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPostotak() {
        return postotak;
    }

    /**
     * Sets the value of the postotak property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPostotak(BigDecimal value) {
        this.postotak = value;
    }

    /**
     * Gets the value of the brPreostalihRata property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBrPreostalihRata() {
        return brPreostalihRata;
    }

    /**
     * Sets the value of the brPreostalihRata property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBrPreostalihRata(Integer value) {
        this.brPreostalihRata = value;
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
