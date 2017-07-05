
package it.univaq.disim.sose.hes.client_measurement;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.univaq.disim.sose.hes.client_measurement package. 
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

    private final static QName _MeasurementRequest_QNAME = new QName("http://it.univaq.disim.sose.hes/measurement", "measurementRequest");
    private final static QName _MeasurementResponse_QNAME = new QName("http://it.univaq.disim.sose.hes/measurement", "measurementResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.univaq.disim.sose.hes.client_measurement
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MeasurementRequest }
     * 
     */
    public MeasurementRequest createMeasurementRequest() {
        return new MeasurementRequest();
    }

    /**
     * Create an instance of {@link MeasurementResponse }
     * 
     */
    public MeasurementResponse createMeasurementResponse() {
        return new MeasurementResponse();
    }

    /**
     * Create an instance of {@link MeasurementType }
     * 
     */
    public MeasurementType createMeasurementType() {
        return new MeasurementType();
    }

    /**
     * Create an instance of {@link MeasurementInfoType }
     * 
     */
    public MeasurementInfoType createMeasurementInfoType() {
        return new MeasurementInfoType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasurementRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.hes/measurement", name = "measurementRequest")
    public JAXBElement<MeasurementRequest> createMeasurementRequest(MeasurementRequest value) {
        return new JAXBElement<MeasurementRequest>(_MeasurementRequest_QNAME, MeasurementRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasurementResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.hes/measurement", name = "measurementResponse")
    public JAXBElement<MeasurementResponse> createMeasurementResponse(MeasurementResponse value) {
        return new JAXBElement<MeasurementResponse>(_MeasurementResponse_QNAME, MeasurementResponse.class, null, value);
    }

}
