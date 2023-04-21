package com.example.springbootmicroservice.services;

import com.example.sprinbootmicroservice.models.WorldAPIResponse;

public interface TimezoneRESTAPIService {

	public boolean checkValidUSTimeZone(String timezone);
	
	public WorldAPIResponse getTimeZoneDetails(String timezone);

}
