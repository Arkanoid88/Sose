package it.univaq.disim.sose.hes.patient.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.univaq.disim.sose.hes.patient.PatientPT;
import it.univaq.disim.sose.hes.patient.PatientInfoRequest;
import it.univaq.disim.sose.hes.patient.PatientInfoResponse;
import it.univaq.disim.sose.hes.patient.PatientType;
import it.univaq.disim.sose.hes.patient.business.PatientService;
import it.univaq.disim.sose.hes.patient.business.model.Patient;
import it.univaq.disim.sose.hes.patient.AddressType;

@Component(value="PatientPTImpl")
public class PatientPTImpl implements PatientPT{

	@Autowired
	private PatientService service;
	
	@Override
	public PatientInfoResponse patientinfo(PatientInfoRequest parameters) {
		try {
			// Retrieve account from DB
			Patient patient = service.getPatient(parameters.getID());

			// Preparing response
			PatientInfoResponse response = new PatientInfoResponse();
			
			// Filling the patients fields with the information coming from the DB
			PatientType patientType = new PatientType();
			patientType.setName( patient.getName() );
			patientType.setDescription(patient.getDescription());
			patientType.setPathologies(patient.getPathologies());
			response.setPatientinfo(patientType);
			
			// Filling the patients (address) fields with the information coming from the DB
			AddressType addressType = new AddressType();
			addressType.setStreet(patient.getAddress().getStreet());
			addressType.setCity(patient.getAddress().getCity());
			addressType.setCountry(patient.getAddress().getCountry());
			
			response.setAddress(addressType);
			
			return response;		} 
		catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}
		
	}

}
