
package com.sonos.smapi.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sonos.services._1 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Password_QNAME = new QName("http://www.sonos.com/Services/1.1", "password");
    private final static QName _Label_QNAME = new QName("http://www.sonos.com/Services/1.1", "label");
    private final static QName _ItemType_QNAME = new QName("http://www.sonos.com/Services/1.1", "itemType");
    private final static QName _SessionId_QNAME = new QName("http://www.sonos.com/Services/1.1", "sessionId");
    private final static QName _Username_QNAME = new QName("http://www.sonos.com/Services/1.1", "username");
    private final static QName _Id_QNAME = new QName("http://www.sonos.com/Services/1.1", "id");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sonos.services._1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetMediaMetadataResponse }
     * 
     */
    public GetMediaMetadataResponse createGetMediaMetadataResponse() {
        return new GetMediaMetadataResponse();
    }

    /**
     * Create an instance of {@link ItemRating }
     * 
     */
    public ItemRating createItemRating() {
        return new ItemRating();
    }

    /**
     * Create an instance of {@link GetSessionId }
     * 
     */
    public GetSessionId createGetSessionId() {
        return new GetSessionId();
    }

    /**
     * Create an instance of {@link GetScrollIndices }
     * 
     */
    public GetScrollIndices createGetScrollIndices() {
        return new GetScrollIndices();
    }

    /**
     * Create an instance of {@link DeleteItem }
     * 
     */
    public DeleteItem createDeleteItem() {
        return new DeleteItem();
    }

    /**
     * Create an instance of {@link RelatedBrowse }
     * 
     */
    public RelatedBrowse createRelatedBrowse() {
        return new RelatedBrowse();
    }

    /**
     * Create an instance of {@link ExtendedMetadata }
     * 
     */
    public ExtendedMetadata createExtendedMetadata() {
        return new ExtendedMetadata();
    }

    /**
     * Create an instance of {@link Search }
     * 
     */
    public Search createSearch() {
        return new Search();
    }

    /**
     * Create an instance of {@link DynamicData }
     * 
     */
    public DynamicData createDynamicData() {
        return new DynamicData();
    }

    /**
     * Create an instance of {@link SearchResponse }
     * 
     */
    public SearchResponse createSearchResponse() {
        return new SearchResponse();
    }

    /**
     * Create an instance of {@link GetMetadata }
     * 
     */
    public GetMetadata createGetMetadata() {
        return new GetMetadata();
    }

    /**
     * Create an instance of {@link MediaCollection }
     * 
     */
    public MediaCollection createMediaCollection() {
        return new MediaCollection();
    }

    /**
     * Create an instance of {@link GetExtendedMetadataResponse }
     * 
     */
    public GetExtendedMetadataResponse createGetExtendedMetadataResponse() {
        return new GetExtendedMetadataResponse();
    }

    /**
     * Create an instance of {@link SetPlayedSecondsResponse }
     * 
     */
    public SetPlayedSecondsResponse createSetPlayedSecondsResponse() {
        return new SetPlayedSecondsResponse();
    }

    /**
     * Create an instance of {@link GetSessionIdResponse }
     * 
     */
    public GetSessionIdResponse createGetSessionIdResponse() {
        return new GetSessionIdResponse();
    }

    /**
     * Create an instance of {@link GetExtendedMetadataTextResponse }
     * 
     */
    public GetExtendedMetadataTextResponse createGetExtendedMetadataTextResponse() {
        return new GetExtendedMetadataTextResponse();
    }

    /**
     * Create an instance of {@link MediaMetadata }
     * 
     */
    public MediaMetadata createMediaMetadata() {
        return new MediaMetadata();
    }

    /**
     * Create an instance of {@link Property }
     * 
     */
    public Property createProperty() {
        return new Property();
    }

    /**
     * Create an instance of {@link StreamMetadata }
     * 
     */
    public StreamMetadata createStreamMetadata() {
        return new StreamMetadata();
    }

    /**
     * Create an instance of {@link GetScrollIndicesResponse }
     * 
     */
    public GetScrollIndicesResponse createGetScrollIndicesResponse() {
        return new GetScrollIndicesResponse();
    }

    /**
     * Create an instance of {@link GetMediaURIResponse }
     * 
     */
    public GetMediaURIResponse createGetMediaURIResponse() {
        return new GetMediaURIResponse();
    }

    /**
     * Create an instance of {@link ReportStatusResponse }
     * 
     */
    public ReportStatusResponse createReportStatusResponse() {
        return new ReportStatusResponse();
    }

    /**
     * Create an instance of {@link GetExtendedMetadataText }
     * 
     */
    public GetExtendedMetadataText createGetExtendedMetadataText() {
        return new GetExtendedMetadataText();
    }

    /**
     * Create an instance of {@link CreateItemResponse }
     * 
     */
    public CreateItemResponse createCreateItemResponse() {
        return new CreateItemResponse();
    }

    /**
     * Create an instance of {@link LastUpdate }
     * 
     */
    public LastUpdate createLastUpdate() {
        return new LastUpdate();
    }

    /**
     * Create an instance of {@link GetLastUpdateResponse }
     * 
     */
    public GetLastUpdateResponse createGetLastUpdateResponse() {
        return new GetLastUpdateResponse();
    }

    /**
     * Create an instance of {@link GetExtendedMetadata }
     * 
     */
    public GetExtendedMetadata createGetExtendedMetadata() {
        return new GetExtendedMetadata();
    }

    /**
     * Create an instance of {@link GetMediaMetadata }
     * 
     */
    public GetMediaMetadata createGetMediaMetadata() {
        return new GetMediaMetadata();
    }

    /**
     * Create an instance of {@link CreateItem }
     * 
     */
    public CreateItem createCreateItem() {
        return new CreateItem();
    }

    /**
     * Create an instance of {@link ReportStatus }
     * 
     */
    public ReportStatus createReportStatus() {
        return new ReportStatus();
    }

    /**
     * Create an instance of {@link RelatedText }
     * 
     */
    public RelatedText createRelatedText() {
        return new RelatedText();
    }

    /**
     * Create an instance of {@link Credentials }
     * 
     */
    public Credentials createCredentials() {
        return new Credentials();
    }

    /**
     * Create an instance of {@link RateItem }
     * 
     */
    public RateItem createRateItem() {
        return new RateItem();
    }

    /**
     * Create an instance of {@link RateItemResponse }
     * 
     */
    public RateItemResponse createRateItemResponse() {
        return new RateItemResponse();
    }

    /**
     * Create an instance of {@link MediaList }
     * 
     */
    public MediaList createMediaList() {
        return new MediaList();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link DeleteItemResponse }
     * 
     */
    public DeleteItemResponse createDeleteItemResponse() {
        return new DeleteItemResponse();
    }

    /**
     * Create an instance of {@link TrackMetadata }
     * 
     */
    public TrackMetadata createTrackMetadata() {
        return new TrackMetadata();
    }

    /**
     * Create an instance of {@link GetMetadataResponse }
     * 
     */
    public GetMetadataResponse createGetMetadataResponse() {
        return new GetMetadataResponse();
    }

    /**
     * Create an instance of {@link GetLastUpdate }
     * 
     */
    public GetLastUpdate createGetLastUpdate() {
        return new GetLastUpdate();
    }

    /**
     * Create an instance of {@link SetPlayedSeconds }
     * 
     */
    public SetPlayedSeconds createSetPlayedSeconds() {
        return new SetPlayedSeconds();
    }

    /**
     * Create an instance of {@link GetMediaURI }
     * 
     */
    public GetMediaURI createGetMediaURI() {
        return new GetMediaURI();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sonos.com/Services/1.1", name = "password")
    public JAXBElement<String> createPassword(String value) {
        return new JAXBElement<String>(_Password_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sonos.com/Services/1.1", name = "label")
    public JAXBElement<String> createLabel(String value) {
        return new JAXBElement<String>(_Label_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sonos.com/Services/1.1", name = "itemType")
    public JAXBElement<ItemType> createItemType(ItemType value) {
        return new JAXBElement<ItemType>(_ItemType_QNAME, ItemType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sonos.com/Services/1.1", name = "sessionId")
    public JAXBElement<String> createSessionId(String value) {
        return new JAXBElement<String>(_SessionId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sonos.com/Services/1.1", name = "username")
    public JAXBElement<String> createUsername(String value) {
        return new JAXBElement<String>(_Username_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sonos.com/Services/1.1", name = "id")
    public JAXBElement<String> createId(String value) {
        return new JAXBElement<String>(_Id_QNAME, String.class, null, value);
    }

}
