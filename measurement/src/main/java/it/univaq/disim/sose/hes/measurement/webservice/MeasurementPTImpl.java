package it.univaq.disim.sose.hes.measurement.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.univaq.disim.sose.hes.measurement.MeasurementInfoType;
import it.univaq.disim.sose.hes.measurement.MeasurementPT;
import it.univaq.disim.sose.hes.measurement.MeasurementRequest;
import it.univaq.disim.sose.hes.measurement.MeasurementResponse;
import it.univaq.disim.sose.hes.measurement.MeasurementType;
import it.univaq.disim.sose.hes.measurement.MeasurementWriteRequest;
import it.univaq.disim.sose.hes.measurement.MeasurementWriteResponse;
import it.univaq.disim.sose.hes.measurement.business.MeasurementService;
import it.univaq.disim.sose.hes.measurement.business.model.Measurement;

@Component(value="MeasurementPTImpl")
public class MeasurementPTImpl implements MeasurementPT {
	
	@Autowired
	private MeasurementService service;

	@Override // reading from the db
	public MeasurementResponse measurement(MeasurementRequest parameters) {
		
		try {
			// preparing the list to be filled
			List<Measurement> measurements = service.getMeasurements(parameters.getID());
			MeasurementResponse response = new MeasurementResponse();
			
			// retrieving the informations 
			for (Measurement measurement : measurements) {
				MeasurementType Measurement_Type = new MeasurementType();
				Measurement_Type.setIdPatient(measurement.getIdPatient());
				MeasurementInfoType measurementInfoType = new MeasurementInfoType();
				measurementInfoType.setName(measurement.getName());
				measurementInfoType.setLastUpdate(measurement.getLastUpdate());
				measurementInfoType.setDescription(measurement.getDescription());
				Measurement_Type.setMeasurementInfo(measurementInfoType);
				response.getMeasurements().add(Measurement_Type);
			}
			return response;
		} 
		catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}
	}
	

	@Override
	public MeasurementWriteResponse measurementwrite(MeasurementWriteRequest parameters) {
		
		try{
			// writing inside the db
			MeasurementWriteResponse response = new MeasurementWriteResponse();
			Measurement param = new Measurement();
			param.setIdPatient(parameters.getMeasurements().getIdPatient());
			param.setName(parameters.getMeasurements().getMeasurementInfo().getName());
			param.setLastUpdate(parameters.getMeasurements().getMeasurementInfo().getLastUpdate());
			param.setDescription(parameters.getMeasurements().getMeasurementInfo().getDescription());
			// returning the response (true or false)
			response = service.getResponse(param);
		
		return response;
		}
		catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}
	}


}
