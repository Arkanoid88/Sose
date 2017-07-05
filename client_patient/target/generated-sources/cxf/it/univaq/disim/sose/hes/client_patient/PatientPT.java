package it.univaq.disim.sose.hes.client_patient;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;

/**
 * This class was generated by Apache CXF 3.1.6
 * 2017-05-22T15:44:25.676+02:00
 * Generated source version: 3.1.6
 * 
 */
@WebService(targetNamespace = "http://it.univaq.disim.sose.hes/patient", name = "PatientPT")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface PatientPT {

    @WebMethod
    @Action(input = "http://it.univaq.disim.sose.hes/patient/patientinfo", output = "http://it.univaq.disim.sose.hes/patient/patientinfoResponse")
    @WebResult(name = "patientInfoResponse", targetNamespace = "http://it.univaq.disim.sose.hes/patient", partName = "parameters")
    public PatientInfoResponse patientinfo(
        @WebParam(partName = "parameters", name = "patientInfoRequest", targetNamespace = "http://it.univaq.disim.sose.hes/patient")
        PatientInfoRequest parameters
    );
}
