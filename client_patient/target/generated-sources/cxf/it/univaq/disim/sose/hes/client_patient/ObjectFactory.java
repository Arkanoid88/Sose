
package it.univaq.disim.sose.hes.client_patient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.univaq.disim.sose.hes.client_patient package. 
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

    private final static QName _PatientInfoRequest_QNAME = new QName("http://it.univaq.disim.sose.hes/patient", "patientInfoRequest");
    private final static QName _PatientInfoResponse_QNAME = new QName("http://it.univaq.disim.sose.hes/patient", "patientInfoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.univaq.disim.sose.hes.client_patient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PatientInfoRequest }
     * 
     */
    public PatientInfoRequest createPatientInfoRequest() {
        return new PatientInfoRequest();
    }

    /**
     * Create an instance of {@link PatientInfoResponse }
     * 
     */
    public PatientInfoResponse createPatientInfoResponse() {
        return new PatientInfoResponse();
    }

    /**
     * Create an instance of {@link PatientType }
     * 
     */
    public PatientType createPatientType() {
        return new PatientType();
    }

    /**
     * Create an instance of {@link AddressType }
     * 
     */
    public AddressType createAddressType() {
        return new AddressType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PatientInfoRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.hes/patient", name = "patientInfoRequest")
    public JAXBElement<PatientInfoRequest> createPatientInfoRequest(PatientInfoRequest value) {
        return new JAXBElement<PatientInfoRequest>(_PatientInfoRequest_QNAME, PatientInfoRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PatientInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.hes/patient", name = "patientInfoResponse")
    public JAXBElement<PatientInfoResponse> createPatientInfoResponse(PatientInfoResponse value) {
        return new JAXBElement<PatientInfoResponse>(_PatientInfoResponse_QNAME, PatientInfoResponse.class, null, value);
    }

}
