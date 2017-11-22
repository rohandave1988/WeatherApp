package org.weatherapi.reporter;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.weatherapi.reporter.CityWeatherService;
import org.weatherapi.reporter.CityWeatherServiceRequestDTO;
import org.weatherapi.reporter.CityWeatherServiceResponseDTO;

public class CityWeatherServiceTest {

	@Test
	public void test() {
		CityWeatherServiceResponseDTO response = (CityWeatherServiceResponseDTO)
				new CityWeatherService().service(
						new CityWeatherServiceRequestDTO("Sydney"));
		assertNotNull(response.getJsonResponse());
		assertTrue(response.getJsonResponse().contains("weather"));
	}

}
