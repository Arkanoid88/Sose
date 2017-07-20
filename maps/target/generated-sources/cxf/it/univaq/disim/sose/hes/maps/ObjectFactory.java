
package it.univaq.disim.sose.hes.maps;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.univaq.disim.sose.hes.maps package. 
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

    private final static QName _MapsRequest_QNAME = new QName("http://it.univaq.disim.sose.hes/maps", "mapsRequest");
    private final static QName _MapsResponse_QNAME = new QName("http://it.univaq.disim.sose.hes/maps", "mapsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.univaq.disim.sose.hes.maps
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MapsRequest }
     * 
     */
    public MapsRequest createMapsRequest() {
        return new MapsRequest();
    }

    /**
     * Create an instance of {@link MapsResponse }
     * 
     */
    public MapsResponse createMapsResponse() {
        return new MapsResponse();
    }

    /**
     * Create an instance of {@link AddressType }
     * 
     */
    public AddressType createAddressType() {
        return new AddressType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MapsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.hes/maps", name = "mapsRequest")
    public JAXBElement<MapsRequest> createMapsRequest(MapsRequest value) {
        return new JAXBElement<MapsRequest>(_MapsRequest_QNAME, MapsRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MapsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.hes/maps", name = "mapsResponse")
    public JAXBElement<MapsResponse> createMapsResponse(MapsResponse value) {
        return new JAXBElement<MapsResponse>(_MapsResponse_QNAME, MapsResponse.class, null, value);
    }

}
