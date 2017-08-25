package it.univaq.disim.sose.hes.measurement.business;

import java.util.List;

import it.univaq.disim.sose.hes.measurement.MeasurementWriteResponse;
import it.univaq.disim.sose.hes.measurement.business.model.Measurement;

public interface MeasurementService {
	List<Measurement> getMeasurements(int ID) throws BusinessException;
	MeasurementWriteResponse getResponse(Measurement parameters) throws BusinessException;
}
