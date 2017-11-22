package org.weatherapi.reporter;

/**
 * 
 * JSON Response containing city weather information for GET request 
 * of type CityWeather.
 * 
 * @author Rohan Dave
 *
 */
public class CityWeatherServiceResponseDTO implements ServiceResponse{

	private final String jsonResponse;
	
	public CityWeatherServiceResponseDTO(String response) {
		this.jsonResponse = response;
	}
	
	public String getJsonResponse() {
		return this.jsonResponse;
	}
}
