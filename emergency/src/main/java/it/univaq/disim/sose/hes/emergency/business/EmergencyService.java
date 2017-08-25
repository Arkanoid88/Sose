package it.univaq.disim.sose.hes.emergency.business;

import it.univaq.disim.sose.hes.emergency.ResponseType;

public interface EmergencyService {

	Runnable SimpleTasks(int id, int i, int serviceId, ResponseType result) throws BusinessException;

}
