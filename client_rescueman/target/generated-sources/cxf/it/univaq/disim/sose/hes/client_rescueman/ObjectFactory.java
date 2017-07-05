
package it.univaq.disim.sose.hes.client_rescueman;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.univaq.disim.sose.hes.client_rescueman package. 
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

    private final static QName _GetInfoRequestMessage_QNAME = new QName("http://it.univaq.disim.sose.hes/emergency", "getInfoRequestMessage");
    private final static QName _GetInfoResponseMessage_QNAME = new QName("http://it.univaq.disim.sose.hes/emergency", "getInfoResponseMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.univaq.disim.sose.hes.client_rescueman
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetInfoRequest }
     * 
     */
    public GetInfoRequest createGetInfoRequest() {
        return new GetInfoRequest();
    }

    /**
     * Create an instance of {@link GetInfoResponse }
     * 
     */
    public GetInfoResponse createGetInfoResponse() {
        return new GetInfoResponse();
    }

    /**
     * Create an instance of {@link ResponseType }
     * 
     */
    public ResponseType createResponseType() {
        return new ResponseType();
    }

    /**
     * Create an instance of {@link ResponseInfoType }
     * 
     */
    public ResponseInfoType createResponseInfoType() {
        return new ResponseInfoType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfoRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.hes/emergency", name = "getInfoRequestMessage")
    public JAXBElement<GetInfoRequest> createGetInfoRequestMessage(GetInfoRequest value) {
        return new JAXBElement<GetInfoRequest>(_GetInfoRequestMessage_QNAME, GetInfoRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.hes/emergency", name = "getInfoResponseMessage")
    public JAXBElement<GetInfoResponse> createGetInfoResponseMessage(GetInfoResponse value) {
        return new JAXBElement<GetInfoResponse>(_GetInfoResponseMessage_QNAME, GetInfoResponse.class, null, value);
    }

}
