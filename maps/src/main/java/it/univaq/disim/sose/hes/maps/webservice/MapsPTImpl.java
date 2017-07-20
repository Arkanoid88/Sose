package it.univaq.disim.sose.hes.maps.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.univaq.disim.sose.hes.maps.MapsRequest;
import it.univaq.disim.sose.hes.maps.MapsResponse;
import it.univaq.disim.sose.hes.maps.business.MapsService;
import it.univaq.disim.sose.hes.maps.business.model.Address;
import it.univaq.disim.sose.hes.maps.MapsPT;


@Component(value="MapsPTImpl")
public class MapsPTImpl implements MapsPT {
	
	@Autowired
	private MapsService service;

	public MapsResponse mapsRequest(MapsRequest parameters) {
		
		// getting all the info in order to make the request to google
		Address origin = new Address();
		origin.setStreet( parameters.getOrigin().getStreet() );
		origin.setCity( parameters.getOrigin().getCity() );
		Address destination = new Address();
		destination.setStreet( parameters.getDestination().getStreet() );
		destination.setCity( parameters.getDestination().getCity() );
		
		MapsResponse response = new MapsResponse();
		
		response = service.getMaps(origin, destination);
	
		return response;
	}

}
