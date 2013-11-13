
package com.sonos.smapi.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="getMediaURIResult" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getMediaURIResult"
})
@XmlRootElement(name = "getMediaURIResponse")
public class GetMediaURIResponse {

    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String getMediaURIResult;

    /**
     * Gets the value of the getMediaURIResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetMediaURIResult() {
        return getMediaURIResult;
    }

    /**
     * Sets the value of the getMediaURIResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetMediaURIResult(String value) {
        this.getMediaURIResult = value;
    }

}
