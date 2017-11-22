package org.weatherapi.reporter;

import static org.junit.Assert.*;

import org.junit.Test;
import org.weatherapi.reporter.CitiesListDAO;

public class CitiesListDAOTest {

	@Test
	public void testLoadOnStartup() {
		CitiesListDAO citiesDAO = CitiesListDAO.getInstance();
		assertTrue(citiesDAO.read().size() > 0);
	}

}
