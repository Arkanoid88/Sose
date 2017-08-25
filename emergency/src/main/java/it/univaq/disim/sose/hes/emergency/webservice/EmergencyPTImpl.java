package it.univaq.disim.sose.hes.emergency.webservice;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.univaq.disim.sose.hes.emergency.GetInfoRequest;
import it.univaq.disim.sose.hes.emergency.GetInfoResponse;
import it.univaq.disim.sose.hes.emergency.ResponseType;
import it.univaq.disim.sose.hes.emergency.EmergencyPT;
import it.univaq.disim.sose.hes.emergency.business.EmergencyService;
import it.univaq.disim.sose.hes.emergency.business.impl.SimpleTasks;

@Component(value = "EmergencyPTImpl")
public class EmergencyPTImpl implements EmergencyPT {

	@SuppressWarnings("unused")
	private static Logger LOGGER = LoggerFactory.getLogger(EmergencyPTImpl.class);

	@Override
	public GetInfoResponse getInfo(GetInfoRequest parameters) throws InterruptedException {
		
		// thread time test
		long tStart0 = System.currentTimeMillis();
		
		GetInfoResponse response = new GetInfoResponse();

		final CountDownLatch latch = new CountDownLatch(1); // sync with the main thread setup
		
		ResponseType result = new ResponseType();
		Thread t1 = new Thread(new SimpleTasks(parameters.getID(), parameters.getServiceId(), result, latch, response));
		Thread t2 = new Thread(new SimpleTasks(parameters.getID(), parameters.getServiceId()+1, result, latch, response));
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		latch.await(); // sync with main thread
		
		// thread time test
		long tEnd = System.currentTimeMillis();
		long tDelta = tEnd - tStart0;
		double elapsedSeconds = tDelta / 1000.0;
		System.out.println("Sono passati "+ elapsedSeconds + " dall'avvio del prosumer.");
		return response;
		
	}
}