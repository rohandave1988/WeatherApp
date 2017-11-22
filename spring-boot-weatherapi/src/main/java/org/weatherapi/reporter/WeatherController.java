package org.weatherapi.reporter;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Class working as controller that would map different requests with the methods
 * 
 * @author Rohan Dave
 * 
 */
@Controller
public class WeatherController {
	
	private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "City", method = RequestMethod.GET)
	public String weather( Model model) {
		return "home";
	}
	
	/**
	 * Gets weather info for all cities.Simply selects the home view to render by returning its name.
	 */
	@ResponseBody
	@RequestMapping(value = "/CityWeather/{city:.+}", method = RequestMethod.GET)
	public String weather(@PathVariable("city") String city/*, Model model*/) {
		String responseText = null;
		if(city != null) {
			CityWeatherServiceResponseDTO response = (CityWeatherServiceResponseDTO)
					new CityWeatherService().service(new CityWeatherServiceRequestDTO(city));
			responseText = response.getJsonResponse();
			/*model.addAttribute("jsonResponse", response.getJsonResponse() );*/
		}
		return responseText;
	}
	
	/**
	 * Gets weather info for all cities.Simply selects the home view to render by returning its name.
	 */
	@ResponseBody
	@RequestMapping(value = "/CityAll", method = RequestMethod.GET)
	public String cities() {

		CityServiceResponse response = (CityServiceResponse)new CityServiceList().service(new ServiceRequest() {
		});
		
		return response.getResponse();
	}

	
}
