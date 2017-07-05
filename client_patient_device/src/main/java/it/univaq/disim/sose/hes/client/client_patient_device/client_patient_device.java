package it.univaq.disim.sose.hes.client.client_patient_device;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import it.univaq.disim.sose.hes.client_patient_device.MeasurementPT;
import it.univaq.disim.sose.hes.client_patient_device.MeasurementService;
import it.univaq.disim.sose.hes.client_patient_device.MeasurementType;
import it.univaq.disim.sose.hes.client_patient_device.MeasurementWriteRequest;
import it.univaq.disim.sose.hes.client_patient_device.MeasurementWriteResponse;
import it.univaq.disim.sose.hes.client_patient_device.MeasurementInfoType;



public class client_patient_device {
	public static void main(String[] args) throws MalformedURLException, IOException{
		
		MeasurementService MeasurementService = new MeasurementService();
		MeasurementPT Measurement = MeasurementService.getMeasurementPort();
		
		MeasurementWriteRequest parameters = new MeasurementWriteRequest();
		MeasurementType measurementtype = new MeasurementType();
		MeasurementInfoType measurements = new MeasurementInfoType();
		
		long t= System.currentTimeMillis();
		
		while(true) { 
			  try {
				  	// filling parameters, these parameters should come from the sensor
					measurementtype.setIdPatient(2);
					measurements.setName("Mario Rossi");
					measurements.setDescription("80 bpm");
					
					// getting the date and formatting to let be readble by the DB
				    Date date = Calendar.getInstance().getTime();
				    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				    String finalDate = sdf.format(date);
					measurements.setLastUpdate(finalDate);
					
					// filling further paramters
					measurementtype.setMeasurementInfo(measurements);
					
					parameters.setMeasurements(measurementtype);
					
					// the request to the prosumer
					MeasurementWriteResponse response = Measurement.measurementwrite(parameters);
					System.out.println(response.isAck());
				
					Thread.sleep( 10000 );// 10 seconds of pause before the next write request
					
					if(System.currentTimeMillis()>t+120000)// after 120000 milliseconds = 120 sec exit from the loop
					{break;}
					
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
		
	}
	
}