package com.example.springbootmicroservice.servicesimpl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.sprinbootmicroservice.models.WorldAPIResponse;
import com.example.springbootmicroservice.services.TimezoneRESTAPIService;

@Service
public class TimezoneRestAPIServiceImpl implements TimezoneRESTAPIService {
	@Autowired
	RestTemplate restTemplate;

	@Override
	public boolean checkValidUSTimeZone(String timezone) {
		String[] usTimezones = { "America/New_York", "America/Chicago", "America/Denver", "America/Los_Angeles" };
		return Arrays.stream(usTimezones).anyMatch(timezone::equals);
	}

	@Override
	public WorldAPIResponse getTimeZoneDetails(String timezone) {
		String apiUrl = String.format("http://worldtimeapi.org/api/timezone/%s", timezone);
		ResponseEntity<WorldAPIResponse> response = restTemplate.getForEntity(apiUrl, WorldAPIResponse.class);
		return response.getBody();
	}

}
