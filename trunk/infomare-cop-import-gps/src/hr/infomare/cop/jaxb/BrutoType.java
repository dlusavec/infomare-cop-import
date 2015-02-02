
package hr.infomare.cop.jaxb;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Tip za bruto plaæu.
 *
 * <p>Java class for brutoType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="brutoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="elementPlace" type="{http://www.fina.hr/cop/opobrazac/v0.6}elementPlace"/>
 *         &lt;element name="internaOznakaUJ" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="20"/>
 *               &lt;whiteSpace value="collapse"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="nazivUJ" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="200"/>
 *               &lt;whiteSpace value="collapse"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="brSati" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;totalDigits value="10"/>
 *               &lt;fractionDigits value="6"/>
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="9999.999999"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="koeficijent" type="{http://www.fina.hr/cop/opobrazac/v0.6}koeficijentType"/>
 *         &lt;element name="osnovica" type="{http://www.fina.hr/cop/opobrazac/v0.6}iznosType" minOccurs="0"/>
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
@XmlType(name = "brutoType", propOrder = {
         "elementPlace", "internaOznakaUJ", "nazivUJ", "brSati", "koeficijent", "osnovica", "iznos"
    })
public class BrutoType {

    @XmlElement(required = true)
    protected ElementPlace elementPlace;
    protected String internaOznakaUJ;
    protected String nazivUJ;
    protected BigDecimal brSati;
    @XmlElement(required = true)
    protected BigDecimal koeficijent;
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
     * Gets the value of the internaOznakaUJ property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getInternaOznakaUJ() {
        return internaOznakaUJ;
    }

    /**
     * Sets the value of the internaOznakaUJ property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setInternaOznakaUJ(String value) {
        this.internaOznakaUJ = value;
    }

    /**
     * Gets the value of the nazivUJ property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNazivUJ() {
        return nazivUJ;
    }

    /**
     * Sets the value of the nazivUJ property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNazivUJ(String value) {
        this.nazivUJ = value;
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
     * Gets the value of the koeficijent property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getKoeficijent() {
        return koeficijent;
    }

    /**
     * Sets the value of the koeficijent property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setKoeficijent(BigDecimal value) {
        this.koeficijent = value;
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
