package org.weatherapi.reporter;

/**
 * 
 * Gets all cities in a JSON array.
 * 
 * @author Rohan Dave
 *
 */
public class CityServiceResponse implements ServiceResponse {

	private final String jsonResponse;
	
	public CityServiceResponse(String response) {
		this.jsonResponse = response;
	}
	
	public String getResponse() {
		return this.jsonResponse;
	}
}
