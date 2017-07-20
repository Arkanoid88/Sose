package it.univaq.disim.sose.hes.maps.business;

import it.univaq.disim.sose.hes.maps.MapsResponse;
import it.univaq.disim.sose.hes.maps.business.model.Address;

public interface MapsService {
	MapsResponse getMaps(Address origin, Address destination);
}
