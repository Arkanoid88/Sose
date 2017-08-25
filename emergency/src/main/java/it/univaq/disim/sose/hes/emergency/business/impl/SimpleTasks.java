package it.univaq.disim.sose.hes.emergency.business.impl;

import java.util.concurrent.CountDownLatch;

import org.springframework.stereotype.Service;

import it.univaq.disim.sose.hes.clients.maps.AddressType;
import it.univaq.disim.sose.hes.clients.maps.MapsPT;
import it.univaq.disim.sose.hes.clients.maps.MapsRequest;
import it.univaq.disim.sose.hes.clients.maps.MapsResponse;
import it.univaq.disim.sose.hes.clients.maps.MapsService;
import it.univaq.disim.sose.hes.clients.measurement.MeasurementPT;
import it.univaq.disim.sose.hes.clients.measurement.MeasurementRequest;
import it.univaq.disim.sose.hes.clients.measurement.MeasurementResponse;
import it.univaq.disim.sose.hes.clients.measurement.MeasurementService;
import it.univaq.disim.sose.hes.clients.patient.PatientInfoRequest;
import it.univaq.disim.sose.hes.clients.patient.PatientInfoResponse;
import it.univaq.disim.sose.hes.clients.patient.PatientPT;
import it.univaq.disim.sose.hes.clients.patient.PatientService;
import it.univaq.disim.sose.hes.emergency.GetInfoResponse;
import it.univaq.disim.sose.hes.emergency.ResponseInfoType;
import it.univaq.disim.sose.hes.emergency.ResponseType;


public class SimpleTasks implements Runnable {

	private int ID, serviceid;
	private ResponseType result;
	private CountDownLatch latch;
	private GetInfoResponse response;

	public SimpleTasks(int i, int s, ResponseType r, CountDownLatch count, GetInfoResponse g) {
		this.ID = i;
		this.serviceid = s;
		this.result = r;
		this.latch = count;
		this.response = g;
	}

	@Override
	public void run() { 
		
		if (this.serviceid == 0) {
			
			// thread time test
			long tStart = System.currentTimeMillis();
			
			int cont = 0;
			
			while(cont < 4)
			{
				// calling services
				MeasurementService MeasurementService = new MeasurementService();
				MeasurementPT Measurement = MeasurementService.getMeasurementPort();
				MeasurementRequest measurementRequest = new MeasurementRequest();
		
				measurementRequest.setID(ID);
				MeasurementResponse measurementResponse = Measurement.measurement(measurementRequest);
				
				//// preparing answer, recovering parameters /////
				ResponseInfoType values = new ResponseInfoType();
				values.setName(measurementResponse.getMeasurements().get(cont).getMeasurementInfo().getName());
				values.setDescription(measurementResponse.getMeasurements().get(cont).getMeasurementInfo().getDescription());
				values.setLastUpdate(measurementResponse.getMeasurements().get(cont).getMeasurementInfo().getLastUpdate());
				result.setResponseInfoType(values);
				this.response.getResponseType().add(result);
				cont = cont + 1;
			}
			///////////////////////////////////////////////////
			
			//sync with the prosumer
			this.latch.countDown();
			
			// thread time test
			long tEnd = System.currentTimeMillis();
			long tDelta = tEnd - tStart;
			double elapsedSeconds = tDelta / 1000.0;
			System.out.println("Sono passati "+ elapsedSeconds + " dall'inizio del thread getInformations.");
		
		}

		if (this.serviceid == 1) {
			
			// thread time test
			long tStart1 = System.currentTimeMillis();

			// patient, recovering all the infromations about the patient from the hospital
			PatientService patientservice = new PatientService();
			PatientPT patientservicept = patientservice.getPatientPort();
			PatientInfoRequest patientrequest = new PatientInfoRequest();
			
			patientrequest.setID(ID);
			PatientInfoResponse patientinforesponse = patientservicept.patientinfo(patientrequest);
		
			//////////////////////////////////////////////////////////////////////////////////////////////////
		
			// maps service
		
			MapsService mapsService = new MapsService();
			MapsPT mapsPT = mapsService.getMapsPort();
			MapsRequest mapsRequest = new MapsRequest();
			
			AddressType origin = new AddressType();
			origin.setStreet("via vetoio");
			origin.setCity("l'aquila");
			origin.setCountry("italia");
			AddressType destination = new AddressType();
			destination.setStreet(patientinforesponse.getAddress().getStreet());
			destination.setCity(patientinforesponse.getAddress().getCity());
			destination.setCountry(patientinforesponse.getAddress().getCountry());
			
			mapsRequest.setOrigin(origin);
			mapsRequest.setDestination(destination);
	
			MapsResponse mapsResponse = mapsPT.mapsRequest(mapsRequest);
			
			result.setMapsUrl(mapsResponse.getMapsurl());
			
			// thread time test
			long i = 0; 
			while(i<=10000000){
				i++;
				System.out.print("i="+i);
			}
			
			//sync with prosumer
			this.latch.countDown();
			
			// thread time test
			long tEnd = System.currentTimeMillis();
			long tDelta = tEnd - tStart1;
			double elapsedSeconds = tDelta / 1000.0;
			System.out.println("Sono passati "+ elapsedSeconds + " dall'inizio del thread maps.");
		}

	}

}