package it.univaq.disim.sose.hes.maps.client.client_maps;


import java.io.IOException;
import java.net.MalformedURLException;

import it.univaq.disim.sose.hes.client_maps.AddressType;
import it.univaq.disim.sose.hes.client_maps.MapsPT;
import it.univaq.disim.sose.hes.client_maps.MapsRequest;
import it.univaq.disim.sose.hes.client_maps.MapsResponse;
import it.univaq.disim.sose.hes.client_maps.MapsService;


public class impl {
	public static void main(String[] args) throws MalformedURLException, IOException{
		
		MapsService mapsService = new MapsService();
		MapsPT mapsPT = mapsService.getMapsPort();
		MapsRequest mapsRequest = new MapsRequest();
		
		AddressType origin = new AddressType();
		origin.setStreet("via roma");
		origin.setCity("l'aquila");
		origin.setCountry("italia");
		AddressType destination = new AddressType();
		destination.setStreet("via avezzano");
		destination.setCity("l'aquila");
		destination.setCountry("italia");
		
		mapsRequest.setOrigin(origin);
		mapsRequest.setDestination(destination);

		MapsResponse mapsResponse = mapsPT.mapsRequest(mapsRequest);
		
		new Renderer(mapsResponse.getMapsurl());
		
		return;
		
	}
	
}