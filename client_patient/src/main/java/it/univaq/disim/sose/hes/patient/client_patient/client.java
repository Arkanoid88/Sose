package it.univaq.disim.sose.hes.patient.client_patient;

import it.univaq.disim.sose.hes.client_patient.PatientInfoRequest;
import it.univaq.disim.sose.hes.client_patient.PatientInfoResponse;
import it.univaq.disim.sose.hes.client_patient.PatientPT;
import it.univaq.disim.sose.hes.client_patient.PatientService;

public class client {
	
	public static void main(String[] args){
		
		PatientService patientservice = new PatientService();
		PatientPT patientpt =  patientservice.getPatientPort();
		
		PatientInfoRequest parameters = new PatientInfoRequest();
		parameters.setID(1);
		PatientInfoResponse patient = patientpt.patientinfo(parameters);
		
		System.out.println(patient.getPatientinfo().getName());
		System.out.println(patient.getPatientinfo().getDescription());
		System.out.println(patient.getPatientinfo().getPathologies());
		System.out.println(patient.getAddress().getCountry());
		System.out.println(patient.getAddress().getCity());
		System.out.println(patient.getAddress().getStreet());
		
	}

}
