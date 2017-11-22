package org.weatherapi.reporter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Gets city weather from http://api.openweathermap.org
 * 
 * @author Rohan Dave
 *
 */
public class CityWeatherService implements Service{

	public static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?q={0}&APPID=578b9d8a9e98060bab1fac5e21651fc1";

	private static final Logger logger = LoggerFactory.getLogger(CityWeatherService.class);
	
	@Override
	public ServiceResponse service(ServiceRequest request) {

		CityWeatherServiceRequestDTO cityWeatherRequest = (CityWeatherServiceRequestDTO)request;
		
		String url = WEATHER_URL.replace("{0}", cityWeatherRequest.getCity());
		
		URL obj;
		StringBuffer response = new StringBuffer();
		try {
			obj = new URL(url);
		
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	
			// optional default is GET
			con.setRequestMethod("GET");
	
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
	
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
		} catch (Exception e) {
			logger.error("Error fetching city weather info: ", e);
		}

		//print result
		logger.info(response.toString());
		
		return new CityWeatherServiceResponseDTO(response.toString());
	}
	
}
