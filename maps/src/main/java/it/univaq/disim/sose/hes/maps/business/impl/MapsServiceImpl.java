package it.univaq.disim.sose.hes.maps.business.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import it.univaq.disim.sose.hes.maps.MapsResponse;
import it.univaq.disim.sose.hes.maps.business.MapsService;
import it.univaq.disim.sose.hes.maps.business.model.Address;


@Service
public class MapsServiceImpl implements MapsService {

	@Override
	public MapsResponse getMaps(Address origin, Address destination) {
		
		// this is the key used by google to use its services, if one is expired can be used the second one
		String googlekey = "AIzaSyBelOVLJgS4clnBdb1o63leayEGEcxtOM4";
		//String googlekey = "AIzaSyALiQ5zurUkHN2_AEV_bbd19zO0q1bAnEU";
		String dynamicinfo;
		try {// sending the url with the source and destination to google
			dynamicinfo = "https://maps.googleapis.com/maps/api/directions/json?origin="+URLEncoder.encode(origin.getCity(), "UTF-8")+"%20"+URLEncoder.encode(origin.getStreet(), "UTF-8")+"%203&destination="+URLEncoder.encode(destination.getCity(), "UTF-8")+"%20"+URLEncoder.encode(destination.getStreet(), "UTF-8")+"%203&mode=driving&key="+googlekey;
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
			// fake address in case of error
			dynamicinfo = "https://maps.googleapis.com/maps/api/directions/json?origin=aquila%20viale%20della%20croce%20rossa%203&destination=aquila%20via%20roma%203&mode=driving&key="+googlekey;
		}

		String rsp = "";
		Scanner sc = null;
		
		try {
			sc = new Scanner(new URL(dynamicinfo).openStream());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while(sc.hasNextLine()) {
			rsp += sc.nextLine();
		}
		sc.close();

		// request to get the static image to be rendered
		JSONObject obj = new JSONObject(rsp);
		JSONArray a = obj.getJSONArray("routes");
		JSONObject o = (JSONObject) a.get(0);
		JSONObject ov = (JSONObject) o.get("overview_polyline");
		String s = (String) ov.getString("points");
		
		String completeSite = "http://maps.googleapis.com/maps/api/staticmap?sensor=false&size=400x400&path=weight:3%7Ccolor:red%7Cenc:"+s;

		MapsResponse response = new MapsResponse();
		response.setMapsurl(completeSite);
		
		return response;
		
	}
	
}