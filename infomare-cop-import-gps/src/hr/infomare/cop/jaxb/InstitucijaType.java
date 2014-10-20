
package hr.infomare.cop.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Tip za podatke poslodavca.
 *
 * <p>Java class for institucijaType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="institucijaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oib" type="{http://www.fina.hr/cop/opobrazac/v0.5}oibType"/>
 *         &lt;element name="naziv">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="200"/>
 *               &lt;whiteSpace value="collapse"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="adresa">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="200"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="razdobljePocetak" type="{http://www.fina.hr/cop/opobrazac/v0.5}datumType"/>
 *         &lt;element name="razdobljeZavrsetak" type="{http://www.fina.hr/cop/opobrazac/v0.5}datumType"/>
 *         &lt;element name="mjBrSati">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="4"/>
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="9999"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="datumObracuna" type="{http://www.fina.hr/cop/opobrazac/v0.5}datumType"/>
 *         &lt;element name="isplata">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}boolean">
 *               &lt;whiteSpace value="collapse"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="brRacInst" type="{http://www.fina.hr/cop/opobrazac/v0.5}brojRacunaType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "institucijaType", propOrder = {
         "oib", "naziv", "adresa", "razdobljePocetak", "razdobljeZavrsetak", "mjBrSati", "datumObracuna", "isplata",
         "brRacInst"
    })
public class InstitucijaType {

    @XmlElement(required = true)
    protected String oib;
    @XmlElement(required = true)
    protected String naziv;
    @XmlElement(required = true)
    protected String adresa;
    @XmlElement(required = true)
    protected String razdobljePocetak;
    @XmlElement(required = true)
    protected String razdobljeZavrsetak;
    protected int mjBrSati;
    @XmlElement(required = true)
    protected String datumObracuna;
    protected boolean isplata;
    protected String brRacInst;

    /**
     * Gets the value of the oib property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOib() {
        return oib;
    }

    /**
     * Sets the value of the oib property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOib(String value) {
        this.oib = value;
    }

    /**
     * Gets the value of the naziv property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Sets the value of the naziv property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNaziv(String value) {
        this.naziv = value;
    }

    /**
     * Gets the value of the adresa property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     * Sets the value of the adresa property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAdresa(String value) {
        this.adresa = value;
    }

    /**
     * Gets the value of the razdobljePocetak property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRazdobljePocetak() {
        return razdobljePocetak;
    }

    /**
     * Sets the value of the razdobljePocetak property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRazdobljePocetak(String value) {
        this.razdobljePocetak = value;
    }

    /**
     * Gets the value of the razdobljeZavrsetak property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRazdobljeZavrsetak() {
        return razdobljeZavrsetak;
    }

    /**
     * Sets the value of the razdobljeZavrsetak property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRazdobljeZavrsetak(String value) {
        this.razdobljeZavrsetak = value;
    }

    /**
     * Gets the value of the mjBrSati property.
     *
     */
    public int getMjBrSati() {
        return mjBrSati;
    }

    /**
     * Sets the value of the mjBrSati property.
     *
     */
    public void setMjBrSati(int value) {
        this.mjBrSati = value;
    }

    /**
     * Gets the value of the datumObracuna property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDatumObracuna() {
        return datumObracuna;
    }

    /**
     * Sets the value of the datumObracuna property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDatumObracuna(String value) {
        this.datumObracuna = value;
    }

    /**
     * Gets the value of the isplata property.
     *
     */
    public boolean isIsplata() {
        return isplata;
    }

    /**
     * Sets the value of the isplata property.
     *
     */
    public void setIsplata(boolean value) {
        this.isplata = value;
    }

    /**
     * Gets the value of the brRacInst property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBrRacInst() {
        return brRacInst;
    }

    /**
     * Sets the value of the brRacInst property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBrRacInst(String value) {
        this.brRacInst = value;
    }

}
