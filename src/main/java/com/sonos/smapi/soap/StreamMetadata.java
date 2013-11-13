
package com.sonos.smapi.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for streamMetadata complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="streamMetadata">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="currentHost" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="currentShowId" type="{http://www.sonos.com/Services/1.1}id" minOccurs="0"/>
 *         &lt;element name="currentShow" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="secondsRemaining" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="secondsToNextShow" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="bitrate" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="logo" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "streamMetadata", propOrder = {
    "currentHost",
    "currentShowId",
    "currentShow",
    "secondsRemaining",
    "secondsToNextShow",
    "bitrate",
    "logo"
})
public class StreamMetadata {

    protected String currentHost;
    protected String currentShowId;
    protected String currentShow;
    protected Integer secondsRemaining;
    protected Integer secondsToNextShow;
    protected Integer bitrate;
    @XmlSchemaType(name = "anyURI")
    protected String logo;

    /**
     * Gets the value of the currentHost property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentHost() {
        return currentHost;
    }

    /**
     * Sets the value of the currentHost property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentHost(String value) {
        this.currentHost = value;
    }

    /**
     * Gets the value of the currentShowId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentShowId() {
        return currentShowId;
    }

    /**
     * Sets the value of the currentShowId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentShowId(String value) {
        this.currentShowId = value;
    }

    /**
     * Gets the value of the currentShow property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentShow() {
        return currentShow;
    }

    /**
     * Sets the value of the currentShow property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentShow(String value) {
        this.currentShow = value;
    }

    /**
     * Gets the value of the secondsRemaining property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSecondsRemaining() {
        return secondsRemaining;
    }

    /**
     * Sets the value of the secondsRemaining property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSecondsRemaining(Integer value) {
        this.secondsRemaining = value;
    }

    /**
     * Gets the value of the secondsToNextShow property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSecondsToNextShow() {
        return secondsToNextShow;
    }

    /**
     * Sets the value of the secondsToNextShow property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSecondsToNextShow(Integer value) {
        this.secondsToNextShow = value;
    }

    /**
     * Gets the value of the bitrate property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBitrate() {
        return bitrate;
    }

    /**
     * Sets the value of the bitrate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBitrate(Integer value) {
        this.bitrate = value;
    }

    /**
     * Gets the value of the logo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogo() {
        return logo;
    }

    /**
     * Sets the value of the logo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogo(String value) {
        this.logo = value;
    }

}