package org.weatherapi.reporter;

/**
 * 
 * A service request to get city weather.
 * 
 * @author Rohan Dave
 *
 */
public class CityWeatherServiceRequestDTO implements ServiceRequest {

	private final String city;
	
	public CityWeatherServiceRequestDTO(String city) {
		this.city = city;
	}
	
	public String getCity() {
		return this.city;
	}
}
