
package com.sonos.smapi.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for mediaCollection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="mediaCollection">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sonos.com/Services/1.1}AbstractMedia">
 *       &lt;sequence>
 *         &lt;element name="artist" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="artistId" type="{http://www.sonos.com/Services/1.1}id" minOccurs="0"/>
 *         &lt;element name="canScroll" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="canPlay" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="canEnumerate" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="canAddToFavorites" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="canCache" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="canSkip" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="albumArtURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="authRequired" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="homogeneous" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="canAddToFavorite" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="readOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mediaCollection", propOrder = {
    "artist",
    "artistId",
    "canScroll",
    "canPlay",
    "canEnumerate",
    "canAddToFavorites",
    "canCache",
    "canSkip",
    "albumArtURI",
    "authRequired",
    "homogeneous",
    "canAddToFavorite"
})
public class MediaCollection
    extends AbstractMedia
{

    protected String artist;
    protected String artistId;
    protected Boolean canScroll;
    protected Boolean canPlay;
    protected Boolean canEnumerate;
    protected Boolean canAddToFavorites;
    protected Boolean canCache;
    protected Boolean canSkip;
    @XmlSchemaType(name = "anyURI")
    protected String albumArtURI;
    protected Boolean authRequired;
    protected Boolean homogeneous;
    protected Boolean canAddToFavorite;
    @XmlAttribute(name = "readOnly")
    protected Boolean readOnly;

    /**
     * Gets the value of the artist property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Sets the value of the artist property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArtist(String value) {
        this.artist = value;
    }

    /**
     * Gets the value of the artistId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArtistId() {
        return artistId;
    }

    /**
     * Sets the value of the artistId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArtistId(String value) {
        this.artistId = value;
    }

    /**
     * Gets the value of the canScroll property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCanScroll() {
        return canScroll;
    }

    /**
     * Sets the value of the canScroll property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCanScroll(Boolean value) {
        this.canScroll = value;
    }

    /**
     * Gets the value of the canPlay property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCanPlay() {
        return canPlay;
    }

    /**
     * Sets the value of the canPlay property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCanPlay(Boolean value) {
        this.canPlay = value;
    }

    /**
     * Gets the value of the canEnumerate property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCanEnumerate() {
        return canEnumerate;
    }

    /**
     * Sets the value of the canEnumerate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCanEnumerate(Boolean value) {
        this.canEnumerate = value;
    }

    /**
     * Gets the value of the canAddToFavorites property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCanAddToFavorites() {
        return canAddToFavorites;
    }

    /**
     * Sets the value of the canAddToFavorites property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCanAddToFavorites(Boolean value) {
        this.canAddToFavorites = value;
    }

    /**
     * Gets the value of the canCache property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCanCache() {
        return canCache;
    }

    /**
     * Sets the value of the canCache property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCanCache(Boolean value) {
        this.canCache = value;
    }

    /**
     * Gets the value of the canSkip property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCanSkip() {
        return canSkip;
    }

    /**
     * Sets the value of the canSkip property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCanSkip(Boolean value) {
        this.canSkip = value;
    }

    /**
     * Gets the value of the albumArtURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlbumArtURI() {
        return albumArtURI;
    }

    /**
     * Sets the value of the albumArtURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlbumArtURI(String value) {
        this.albumArtURI = value;
    }

    /**
     * Gets the value of the authRequired property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAuthRequired() {
        return authRequired;
    }

    /**
     * Sets the value of the authRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAuthRequired(Boolean value) {
        this.authRequired = value;
    }

    /**
     * Gets the value of the homogeneous property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHomogeneous() {
        return homogeneous;
    }

    /**
     * Sets the value of the homogeneous property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHomogeneous(Boolean value) {
        this.homogeneous = value;
    }

    /**
     * Gets the value of the canAddToFavorite property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCanAddToFavorite() {
        return canAddToFavorite;
    }

    /**
     * Sets the value of the canAddToFavorite property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCanAddToFavorite(Boolean value) {
        this.canAddToFavorite = value;
    }

    /**
     * Gets the value of the readOnly property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isReadOnly() {
        if (readOnly == null) {
            return true;
        } else {
            return readOnly;
        }
    }

    /**
     * Sets the value of the readOnly property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReadOnly(Boolean value) {
        this.readOnly = value;
    }

}
