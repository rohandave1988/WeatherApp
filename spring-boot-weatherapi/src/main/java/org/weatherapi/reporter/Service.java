package org.weatherapi.reporter;

/**
 * 
 * A service interface. Implementating classes should perform
 * some sort of service.
 * 
 * @see ServiceRequest
 * @see ServiceResponse
 * 
 * @author Rohan Dave
 *
 */
public interface Service {

	
	public ServiceResponse service(ServiceRequest request);
}
