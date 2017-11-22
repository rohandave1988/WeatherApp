package org.weatherapi.reporter;

import static org.junit.Assert.*;

import org.junit.Test;
import org.weatherapi.reporter.CityServiceList;
import org.weatherapi.reporter.CityServiceResponse;
import org.weatherapi.reporter.ServiceRequest;

public class CityServiceTest {

	@Test
	public void testGetAllCityService() {
		CityServiceResponse response = (CityServiceResponse)new CityServiceList().service(new ServiceRequest() {
			}) ; 
		// Test that there is a response
		assertTrue(response.getResponse() != null);
		//Test that the number of cities loaded are more than 1 atleast.
		// we can safely assume that length greater than 5 would
		// qualify that the response has atleast one city loaded.
		assertTrue(response.getResponse().length() > 5);
	}

}
