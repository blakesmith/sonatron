
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
 *         &lt;element name="httpHeaders" type="{http://www.sonos.com/Services/1.1}httpHeaders" minOccurs="0"/>
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
    "getMediaURIResult",
    "httpHeaders"
})
@XmlRootElement(name = "getMediaURIResponse")
public class GetMediaURIResponse {

    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String getMediaURIResult;
    protected HttpHeaders httpHeaders;

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

    /**
     * Gets the value of the httpHeaders property.
     * 
     * @return
     *     possible object is
     *     {@link HttpHeaders }
     *     
     */
    public HttpHeaders getHttpHeaders() {
        return httpHeaders;
    }

    /**
     * Sets the value of the httpHeaders property.
     * 
     * @param value
     *     allowed object is
     *     {@link HttpHeaders }
     *     
     */
    public void setHttpHeaders(HttpHeaders value) {
        this.httpHeaders = value;
    }

}
