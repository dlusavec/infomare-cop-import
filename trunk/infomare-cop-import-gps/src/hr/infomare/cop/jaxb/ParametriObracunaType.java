
package hr.infomare.cop.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for parametriObracunaType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="parametriObracunaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vrParametra">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="200"/>
 *               &lt;whiteSpace value="collapse"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="period" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="datumOd" type="{http://www.fina.hr/cop/opobrazac/v0.5}datumShortType"/>
 *                   &lt;element name="datumDo" type="{http://www.fina.hr/cop/opobrazac/v0.5}datumShortType"/>
 *                   &lt;element name="opis" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;minLength value="1"/>
 *                         &lt;maxLength value="200"/>
 *                         &lt;whiteSpace value="collapse"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "parametriObracunaType", propOrder = { "vrParametra", "period" })
public class ParametriObracunaType {

    @XmlElement(required = true)
    protected String vrParametra;
    @XmlElement(required = true)
    protected List<ParametriObracunaType.Period> period;

    /**
     * Gets the value of the vrParametra property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getVrParametra() {
        return vrParametra;
    }

    /**
     * Sets the value of the vrParametra property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setVrParametra(String value) {
        this.vrParametra = value;
    }

    /**
     * Gets the value of the period property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the period property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPeriod().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ParametriObracunaType.Period }
     *
     *
     */
    public List<ParametriObracunaType.Period> getPeriod() {
        if (period == null) {
            period = new ArrayList<ParametriObracunaType.Period>();
        }
        return this.period;
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
     *         &lt;element name="datumOd" type="{http://www.fina.hr/cop/opobrazac/v0.5}datumShortType"/>
     *         &lt;element name="datumDo" type="{http://www.fina.hr/cop/opobrazac/v0.5}datumShortType"/>
     *         &lt;element name="opis" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="1"/>
     *               &lt;maxLength value="200"/>
     *               &lt;whiteSpace value="collapse"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "datumOd", "datumDo", "opis" })
    public static class Period {

        @XmlElement(required = true)
        protected String datumOd;
        @XmlElement(required = true)
        protected String datumDo;
        protected String opis;

        /**
         * Gets the value of the datumOd property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getDatumOd() {
            return datumOd;
        }

        /**
         * Sets the value of the datumOd property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setDatumOd(String value) {
            this.datumOd = value;
        }

        /**
         * Gets the value of the datumDo property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getDatumDo() {
            return datumDo;
        }

        /**
         * Sets the value of the datumDo property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setDatumDo(String value) {
            this.datumDo = value;
        }

        /**
         * Gets the value of the opis property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getOpis() {
            return opis;
        }

        /**
         * Sets the value of the opis property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setOpis(String value) {
            this.opis = value;
        }

    }

}
