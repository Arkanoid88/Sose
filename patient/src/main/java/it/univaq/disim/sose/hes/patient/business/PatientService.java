package it.univaq.disim.sose.hes.patient.business;

import it.univaq.disim.sose.hes.patient.business.model.Patient;

public interface PatientService {
	
	Patient getPatient(int ID) throws BusinessException ;

}
