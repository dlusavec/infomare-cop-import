
package hr.infomare.cop.jaxb;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Tip za osnovne podatke zaposlenika.
 *
 * <p>Java class for zaposlenikType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="zaposlenikType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oib" type="{http://www.fina.hr/cop/opobrazac/v0.4}oibType"/>
 *         &lt;element name="ime">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="prezime">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="adresa" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="200"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="racuniZaposlenika" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="brRacZap" type="{http://www.fina.hr/cop/opobrazac/v0.4}brojRacunaType"/>
 *                   &lt;element name="racunBanka">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;minLength value="1"/>
 *                         &lt;maxLength value="200"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="ukIznos" type="{http://www.fina.hr/cop/opobrazac/v0.4}iznosType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
 *         &lt;element name="datumIsplate" type="{http://www.fina.hr/cop/opobrazac/v0.4}datumType" minOccurs="0"/>
 *         &lt;element name="parametriObracuna" type="{http://www.fina.hr/cop/opobrazac/v0.4}parametriObracunaType" maxOccurs="unbounded"/>
 *         &lt;element name="bruto">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="elementBrutoPlace" type="{http://www.fina.hr/cop/opobrazac/v0.4}brutoType" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="ukIznos" type="{http://www.fina.hr/cop/opobrazac/v0.4}iznosType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="doprinosIzPlace">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="elementDoprinosIz" type="{http://www.fina.hr/cop/opobrazac/v0.4}doprinosIzType" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="ukIznos" type="{http://www.fina.hr/cop/opobrazac/v0.4}iznosType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="dohodak" type="{http://www.fina.hr/cop/opobrazac/v0.4}iznosType"/>
 *         &lt;element name="olaksice">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="elementOlaksice" type="{http://www.fina.hr/cop/opobrazac/v0.4}olaksiceType" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="ukIznos" type="{http://www.fina.hr/cop/opobrazac/v0.4}iznosType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="poreznaOsnovica" type="{http://www.fina.hr/cop/opobrazac/v0.4}iznosType"/>
 *         &lt;element name="porezNaDohodakIPrirez">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="elementPorezPrirez" type="{http://www.fina.hr/cop/opobrazac/v0.4}porezPrirezType" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="ukIznos" type="{http://www.fina.hr/cop/opobrazac/v0.4}iznosType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="neto" type="{http://www.fina.hr/cop/opobrazac/v0.4}iznosType"/>
 *         &lt;element name="neoporeziviPrihodi">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="elementNeoporezPrih" type="{http://www.fina.hr/cop/opobrazac/v0.4}neoporeziviPrihodiType" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="ukIznos" type="{http://www.fina.hr/cop/opobrazac/v0.4}iznosType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ukPrimanja" type="{http://www.fina.hr/cop/opobrazac/v0.4}iznosType"/>
 *         &lt;element name="obustave">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="elementObustave" type="{http://www.fina.hr/cop/opobrazac/v0.4}obustaveType" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="ukIznos" type="{http://www.fina.hr/cop/opobrazac/v0.4}iznosType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="iznosZaisplatu" type="{http://www.fina.hr/cop/opobrazac/v0.4}iznosType"/>
 *         &lt;element name="iznosZaIsplatuRazlika" type="{http://www.fina.hr/cop/opobrazac/v0.4}iznosNegPozType" minOccurs="0"/>
 *         &lt;element name="doprinosNaPlacu">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="elementDoprinosNa" type="{http://www.fina.hr/cop/opobrazac/v0.4}doprinosNaType" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="ukIznos" type="{http://www.fina.hr/cop/opobrazac/v0.4}iznosType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ukTrosakPlace" type="{http://www.fina.hr/cop/opobrazac/v0.4}iznosType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "zaposlenikType", propOrder = {
         "oib", "ime", "prezime", "adresa", "racuniZaposlenika", "internaOznakaUJ", "nazivUJ", "datumIsplate",
         "parametriObracuna", "bruto", "doprinosIzPlace", "dohodak", "olaksice", "poreznaOsnovica",
         "porezNaDohodakIPrirez", "neto", "neoporeziviPrihodi", "ukPrimanja", "obustave", "iznosZaisplatu",
         "iznosZaIsplatuRazlika", "doprinosNaPlacu", "ukTrosakPlace"
    })
public class ZaposlenikType {

    @XmlElement(required = true)
    protected String oib;
    @XmlElement(required = true)
    protected String ime;
    @XmlElement(required = true)
    protected String prezime;
    protected String adresa;
    protected List<ZaposlenikType.RacuniZaposlenika> racuniZaposlenika;
    protected String internaOznakaUJ;
    protected String nazivUJ;
    protected String datumIsplate;
    @XmlElement(required = true)
    protected List<ParametriObracunaType> parametriObracuna;
    @XmlElement(required = true)
    protected ZaposlenikType.Bruto bruto;
    @XmlElement(required = true)
    protected ZaposlenikType.DoprinosIzPlace doprinosIzPlace;
    @XmlElement(required = true)
    protected BigDecimal dohodak;
    @XmlElement(required = true)
    protected ZaposlenikType.Olaksice olaksice;
    @XmlElement(required = true)
    protected BigDecimal poreznaOsnovica;
    @XmlElement(required = true)
    protected ZaposlenikType.PorezNaDohodakIPrirez porezNaDohodakIPrirez;
    @XmlElement(required = true)
    protected BigDecimal neto;
    @XmlElement(required = true)
    protected ZaposlenikType.NeoporeziviPrihodi neoporeziviPrihodi;
    @XmlElement(required = true)
    protected BigDecimal ukPrimanja;
    @XmlElement(required = true)
    protected ZaposlenikType.Obustave obustave;
    @XmlElement(required = true)
    protected BigDecimal iznosZaisplatu;
    protected BigDecimal iznosZaIsplatuRazlika;
    @XmlElement(required = true)
    protected ZaposlenikType.DoprinosNaPlacu doprinosNaPlacu;
    @XmlElement(required = true)
    protected BigDecimal ukTrosakPlace;

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
     * Gets the value of the ime property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIme() {
        return ime;
    }

    /**
     * Sets the value of the ime property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIme(String value) {
        this.ime = value;
    }

    /**
     * Gets the value of the prezime property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Sets the value of the prezime property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPrezime(String value) {
        this.prezime = value;
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
     * Gets the value of the racuniZaposlenika property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the racuniZaposlenika property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRacuniZaposlenika().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ZaposlenikType.RacuniZaposlenika }
     *
     *
     */
    public List<ZaposlenikType.RacuniZaposlenika> getRacuniZaposlenika() {
        if (racuniZaposlenika == null) {
            racuniZaposlenika = new ArrayList<ZaposlenikType.RacuniZaposlenika>();
        }
        return this.racuniZaposlenika;
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
     * Gets the value of the datumIsplate property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDatumIsplate() {
        return datumIsplate;
    }

    /**
     * Sets the value of the datumIsplate property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDatumIsplate(String value) {
        this.datumIsplate = value;
    }

    /**
     * Gets the value of the parametriObracuna property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parametriObracuna property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParametriObracuna().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ParametriObracunaType }
     *
     *
     */
    public List<ParametriObracunaType> getParametriObracuna() {
        if (parametriObracuna == null) {
            parametriObracuna = new ArrayList<ParametriObracunaType>();
        }
        return this.parametriObracuna;
    }

    /**
     * Gets the value of the bruto property.
     *
     * @return
     *     possible object is
     *     {@link ZaposlenikType.Bruto }
     *
     */
    public ZaposlenikType.Bruto getBruto() {
        return bruto;
    }

    /**
     * Sets the value of the bruto property.
     *
     * @param value
     *     allowed object is
     *     {@link ZaposlenikType.Bruto }
     *
     */
    public void setBruto(ZaposlenikType.Bruto value) {
        this.bruto = value;
    }

    /**
     * Gets the value of the doprinosIzPlace property.
     *
     * @return
     *     possible object is
     *     {@link ZaposlenikType.DoprinosIzPlace }
     *
     */
    public ZaposlenikType.DoprinosIzPlace getDoprinosIzPlace() {
        return doprinosIzPlace;
    }

    /**
     * Sets the value of the doprinosIzPlace property.
     *
     * @param value
     *     allowed object is
     *     {@link ZaposlenikType.DoprinosIzPlace }
     *
     */
    public void setDoprinosIzPlace(ZaposlenikType.DoprinosIzPlace value) {
        this.doprinosIzPlace = value;
    }

    /**
     * Gets the value of the dohodak property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getDohodak() {
        return dohodak;
    }

    /**
     * Sets the value of the dohodak property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setDohodak(BigDecimal value) {
        this.dohodak = value;
    }

    /**
     * Gets the value of the olaksice property.
     *
     * @return
     *     possible object is
     *     {@link ZaposlenikType.Olaksice }
     *
     */
    public ZaposlenikType.Olaksice getOlaksice() {
        return olaksice;
    }

    /**
     * Sets the value of the olaksice property.
     *
     * @param value
     *     allowed object is
     *     {@link ZaposlenikType.Olaksice }
     *
     */
    public void setOlaksice(ZaposlenikType.Olaksice value) {
        this.olaksice = value;
    }

    /**
     * Gets the value of the poreznaOsnovica property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getPoreznaOsnovica() {
        return poreznaOsnovica;
    }

    /**
     * Sets the value of the poreznaOsnovica property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setPoreznaOsnovica(BigDecimal value) {
        this.poreznaOsnovica = value;
    }

    /**
     * Gets the value of the porezNaDohodakIPrirez property.
     *
     * @return
     *     possible object is
     *     {@link ZaposlenikType.PorezNaDohodakIPrirez }
     *
     */
    public ZaposlenikType.PorezNaDohodakIPrirez getPorezNaDohodakIPrirez() {
        return porezNaDohodakIPrirez;
    }

    /**
     * Sets the value of the porezNaDohodakIPrirez property.
     *
     * @param value
     *     allowed object is
     *     {@link ZaposlenikType.PorezNaDohodakIPrirez }
     *
     */
    public void setPorezNaDohodakIPrirez(ZaposlenikType.PorezNaDohodakIPrirez value) {
        this.porezNaDohodakIPrirez = value;
    }

    /**
     * Gets the value of the neto property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getNeto() {
        return neto;
    }

    /**
     * Sets the value of the neto property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setNeto(BigDecimal value) {
        this.neto = value;
    }

    /**
     * Gets the value of the neoporeziviPrihodi property.
     *
     * @return
     *     possible object is
     *     {@link ZaposlenikType.NeoporeziviPrihodi }
     *
     */
    public ZaposlenikType.NeoporeziviPrihodi getNeoporeziviPrihodi() {
        return neoporeziviPrihodi;
    }

    /**
     * Sets the value of the neoporeziviPrihodi property.
     *
     * @param value
     *     allowed object is
     *     {@link ZaposlenikType.NeoporeziviPrihodi }
     *
     */
    public void setNeoporeziviPrihodi(ZaposlenikType.NeoporeziviPrihodi value) {
        this.neoporeziviPrihodi = value;
    }

    /**
     * Gets the value of the ukPrimanja property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getUkPrimanja() {
        return ukPrimanja;
    }

    /**
     * Sets the value of the ukPrimanja property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setUkPrimanja(BigDecimal value) {
        this.ukPrimanja = value;
    }

    /**
     * Gets the value of the obustave property.
     *
     * @return
     *     possible object is
     *     {@link ZaposlenikType.Obustave }
     *
     */
    public ZaposlenikType.Obustave getObustave() {
        return obustave;
    }

    /**
     * Sets the value of the obustave property.
     *
     * @param value
     *     allowed object is
     *     {@link ZaposlenikType.Obustave }
     *
     */
    public void setObustave(ZaposlenikType.Obustave value) {
        this.obustave = value;
    }

    /**
     * Gets the value of the iznosZaisplatu property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getIznosZaisplatu() {
        return iznosZaisplatu;
    }

    /**
     * Sets the value of the iznosZaisplatu property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setIznosZaisplatu(BigDecimal value) {
        this.iznosZaisplatu = value;
    }

    /**
     * Gets the value of the iznosZaIsplatuRazlika property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getIznosZaIsplatuRazlika() {
        return iznosZaIsplatuRazlika;
    }

    /**
     * Sets the value of the iznosZaIsplatuRazlika property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setIznosZaIsplatuRazlika(BigDecimal value) {
        this.iznosZaIsplatuRazlika = value;
    }

    /**
     * Gets the value of the doprinosNaPlacu property.
     *
     * @return
     *     possible object is
     *     {@link ZaposlenikType.DoprinosNaPlacu }
     *
     */
    public ZaposlenikType.DoprinosNaPlacu getDoprinosNaPlacu() {
        return doprinosNaPlacu;
    }

    /**
     * Sets the value of the doprinosNaPlacu property.
     *
     * @param value
     *     allowed object is
     *     {@link ZaposlenikType.DoprinosNaPlacu }
     *
     */
    public void setDoprinosNaPlacu(ZaposlenikType.DoprinosNaPlacu value) {
        this.doprinosNaPlacu = value;
    }

    /**
     * Gets the value of the ukTrosakPlace property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getUkTrosakPlace() {
        return ukTrosakPlace;
    }

    /**
     * Sets the value of the ukTrosakPlace property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setUkTrosakPlace(BigDecimal value) {
        this.ukTrosakPlace = value;
    }


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
     *         &lt;element name="elementBrutoPlace" type="{http://www.fina.hr/cop/opobrazac/v0.4}brutoType" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="ukIznos" type="{http://www.fina.hr/cop/opobrazac/v0.4}iznosType"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "elementBrutoPlace", "ukIznos" })
    public static class Bruto {

        protected List<BrutoType> elementBrutoPlace;
        @XmlElement(required = true)
        protected BigDecimal ukIznos;

        /**
         * Gets the value of the elementBrutoPlace property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the elementBrutoPlace property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getElementBrutoPlace().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BrutoType }
         *
         *
         */
        public List<BrutoType> getElementBrutoPlace() {
            if (elementBrutoPlace == null) {
                elementBrutoPlace = new ArrayList<BrutoType>();
            }
            return this.elementBrutoPlace;
        }

        /**
         * Gets the value of the ukIznos property.
         *
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *
         */
        public BigDecimal getUkIznos() {
            return ukIznos;
        }

        /**
         * Sets the value of the ukIznos property.
         *
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *
         */
        public void setUkIznos(BigDecimal value) {
            this.ukIznos = value;
        }

    }


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
     *         &lt;element name="elementDoprinosIz" type="{http://www.fina.hr/cop/opobrazac/v0.4}doprinosIzType" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="ukIznos" type="{http://www.fina.hr/cop/opobrazac/v0.4}iznosType"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "elementDoprinosIz", "ukIznos" })
    public static class DoprinosIzPlace {

        protected List<DoprinosIzType> elementDoprinosIz;
        @XmlElement(required = true)
        protected BigDecimal ukIznos;

        /**
         * Gets the value of the elementDoprinosIz property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the elementDoprinosIz property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getElementDoprinosIz().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DoprinosIzType }
         *
         *
         */
        public List<DoprinosIzType> getElementDoprinosIz() {
            if (elementDoprinosIz == null) {
                elementDoprinosIz = new ArrayList<DoprinosIzType>();
            }
            return this.elementDoprinosIz;
        }

        /**
         * Gets the value of the ukIznos property.
         *
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *
         */
        public BigDecimal getUkIznos() {
            return ukIznos;
        }

        /**
         * Sets the value of the ukIznos property.
         *
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *
         */
        public void setUkIznos(BigDecimal value) {
            this.ukIznos = value;
        }

    }


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
     *         &lt;element name="elementDoprinosNa" type="{http://www.fina.hr/cop/opobrazac/v0.4}doprinosNaType" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="ukIznos" type="{http://www.fina.hr/cop/opobrazac/v0.4}iznosType"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "elementDoprinosNa", "ukIznos" })
    public static class DoprinosNaPlacu {

        protected List<DoprinosNaType> elementDoprinosNa;
        @XmlElement(required = true)
        protected BigDecimal ukIznos;

        /**
         * Gets the value of the elementDoprinosNa property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the elementDoprinosNa property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getElementDoprinosNa().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DoprinosNaType }
         *
         *
         */
        public List<DoprinosNaType> getElementDoprinosNa() {
            if (elementDoprinosNa == null) {
                elementDoprinosNa = new ArrayList<DoprinosNaType>();
            }
            return this.elementDoprinosNa;
        }

        /**
         * Gets the value of the ukIznos property.
         *
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *
         */
        public BigDecimal getUkIznos() {
            return ukIznos;
        }

        /**
         * Sets the value of the ukIznos property.
         *
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *
         */
        public void setUkIznos(BigDecimal value) {
            this.ukIznos = value;
        }

    }


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
     *         &lt;element name="elementNeoporezPrih" type="{http://www.fina.hr/cop/opobrazac/v0.4}neoporeziviPrihodiType" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="ukIznos" type="{http://www.fina.hr/cop/opobrazac/v0.4}iznosType"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "elementNeoporezPrih", "ukIznos" })
    public static class NeoporeziviPrihodi {

        protected List<NeoporeziviPrihodiType> elementNeoporezPrih;
        @XmlElement(required = true)
        protected BigDecimal ukIznos;

        /**
         * Gets the value of the elementNeoporezPrih property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the elementNeoporezPrih property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getElementNeoporezPrih().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link NeoporeziviPrihodiType }
         *
         *
         */
        public List<NeoporeziviPrihodiType> getElementNeoporezPrih() {
            if (elementNeoporezPrih == null) {
                elementNeoporezPrih = new ArrayList<NeoporeziviPrihodiType>();
            }
            return this.elementNeoporezPrih;
        }

        /**
         * Gets the value of the ukIznos property.
         *
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *
         */
        public BigDecimal getUkIznos() {
            return ukIznos;
        }

        /**
         * Sets the value of the ukIznos property.
         *
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *
         */
        public void setUkIznos(BigDecimal value) {
            this.ukIznos = value;
        }

    }


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
     *         &lt;element name="elementObustave" type="{http://www.fina.hr/cop/opobrazac/v0.4}obustaveType" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="ukIznos" type="{http://www.fina.hr/cop/opobrazac/v0.4}iznosType"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "elementObustave", "ukIznos" })
    public static class Obustave {

        protected List<ObustaveType> elementObustave;
        @XmlElement(required = true)
        protected BigDecimal ukIznos;

        /**
         * Gets the value of the elementObustave property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the elementObustave property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getElementObustave().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ObustaveType }
         *
         *
         */
        public List<ObustaveType> getElementObustave() {
            if (elementObustave == null) {
                elementObustave = new ArrayList<ObustaveType>();
            }
            return this.elementObustave;
        }

        /**
         * Gets the value of the ukIznos property.
         *
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *
         */
        public BigDecimal getUkIznos() {
            return ukIznos;
        }

        /**
         * Sets the value of the ukIznos property.
         *
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *
         */
        public void setUkIznos(BigDecimal value) {
            this.ukIznos = value;
        }

    }


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
     *         &lt;element name="elementOlaksice" type="{http://www.fina.hr/cop/opobrazac/v0.4}olaksiceType" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="ukIznos" type="{http://www.fina.hr/cop/opobrazac/v0.4}iznosType"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "elementOlaksice", "ukIznos" })
    public static class Olaksice {

        protected List<OlaksiceType> elementOlaksice;
        @XmlElement(required = true)
        protected BigDecimal ukIznos;

        /**
         * Gets the value of the elementOlaksice property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the elementOlaksice property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getElementOlaksice().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link OlaksiceType }
         *
         *
         */
        public List<OlaksiceType> getElementOlaksice() {
            if (elementOlaksice == null) {
                elementOlaksice = new ArrayList<OlaksiceType>();
            }
            return this.elementOlaksice;
        }

        /**
         * Gets the value of the ukIznos property.
         *
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *
         */
        public BigDecimal getUkIznos() {
            return ukIznos;
        }

        /**
         * Sets the value of the ukIznos property.
         *
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *
         */
        public void setUkIznos(BigDecimal value) {
            this.ukIznos = value;
        }

    }


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
     *         &lt;element name="elementPorezPrirez" type="{http://www.fina.hr/cop/opobrazac/v0.4}porezPrirezType" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="ukIznos" type="{http://www.fina.hr/cop/opobrazac/v0.4}iznosType"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "elementPorezPrirez", "ukIznos" })
    public static class PorezNaDohodakIPrirez {

        protected List<PorezPrirezType> elementPorezPrirez;
        @XmlElement(required = true)
        protected BigDecimal ukIznos;

        /**
         * Gets the value of the elementPorezPrirez property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the elementPorezPrirez property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getElementPorezPrirez().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PorezPrirezType }
         *
         *
         */
        public List<PorezPrirezType> getElementPorezPrirez() {
            if (elementPorezPrirez == null) {
                elementPorezPrirez = new ArrayList<PorezPrirezType>();
            }
            return this.elementPorezPrirez;
        }

        /**
         * Gets the value of the ukIznos property.
         *
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *
         */
        public BigDecimal getUkIznos() {
            return ukIznos;
        }

        /**
         * Sets the value of the ukIznos property.
         *
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *
         */
        public void setUkIznos(BigDecimal value) {
            this.ukIznos = value;
        }

    }


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
     *         &lt;element name="brRacZap" type="{http://www.fina.hr/cop/opobrazac/v0.4}brojRacunaType"/>
     *         &lt;element name="racunBanka">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="1"/>
     *               &lt;maxLength value="200"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ukIznos" type="{http://www.fina.hr/cop/opobrazac/v0.4}iznosType" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "brRacZap", "racunBanka", "ukIznos" })
    public static class RacuniZaposlenika {

        @XmlElement(required = true)
        protected String brRacZap;
        @XmlElement(required = true)
        protected String racunBanka;
        protected BigDecimal ukIznos;

        /**
         * Gets the value of the brRacZap property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getBrRacZap() {
            return brRacZap;
        }

        /**
         * Sets the value of the brRacZap property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setBrRacZap(String value) {
            this.brRacZap = value;
        }

        /**
         * Gets the value of the racunBanka property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getRacunBanka() {
            return racunBanka;
        }

        /**
         * Sets the value of the racunBanka property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setRacunBanka(String value) {
            this.racunBanka = value;
        }

        /**
         * Gets the value of the ukIznos property.
         *
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *
         */
        public BigDecimal getUkIznos() {
            return ukIznos;
        }

        /**
         * Sets the value of the ukIznos property.
         *
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *
         */
        public void setUkIznos(BigDecimal value) {
            this.ukIznos = value;
        }

    }

}
