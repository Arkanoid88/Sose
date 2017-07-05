package it.univaq.disim.sose.hes.measurement.client.client_measurement;

import java.io.IOException;
import java.net.MalformedURLException;

import it.univaq.disim.sose.hes.client_measurement.MeasurementPT;
import it.univaq.disim.sose.hes.client_measurement.MeasurementRequest;
import it.univaq.disim.sose.hes.client_measurement.MeasurementResponse;
import it.univaq.disim.sose.hes.client_measurement.MeasurementService;

public class client_measurement {
	public static void main(String[] args) throws MalformedURLException, IOException{
		
		MeasurementService osmMeasurementService = new MeasurementService();
		MeasurementPT osmMeasurement = osmMeasurementService.getMeasurementPort();
		MeasurementRequest measurementRequest = new MeasurementRequest();
		//QUI TUTTI I SET IN MeasurementRequest.java

		measurementRequest.setID(1);
		MeasurementResponse measurementResponse = osmMeasurement.measurement(measurementRequest);
		System.out.print(measurementResponse.getMeasurements().get(0).getIdPatient());
		System.out.println("ciao2");
		
	}
	
}