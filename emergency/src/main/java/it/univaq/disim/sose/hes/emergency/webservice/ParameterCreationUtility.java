package it.univaq.disim.sose.hes.emergency.webservice;

import it.univaq.disim.sose.hes.emergency.GetInfoRequest;
import it.univaq.disim.sose.hes.emergency.business.model.Info;

public class ParameterCreationUtility {
	
	public static Info createInfo(GetInfoRequest request) {
		Info result = new Info();
		result.setIdPatient(request.getID());
		
		return result;
		
	}

}
