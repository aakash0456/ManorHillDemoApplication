package com.example.springbootmicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.sprinbootmicroservice.models.APIResponse;
import com.example.sprinbootmicroservice.models.WorldAPIResponse;
import com.example.springbootmicroservice.services.TimezoneRESTAPIService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin

public class TimezoneController {

	@Autowired
	TimezoneRESTAPIService timezoneRESTAPIService;
	
	@Autowired
	ObjectMapper objectMapper;

	@GetMapping("/time")
	public ResponseEntity<APIResponse> getTime(@RequestParam String timezone) {
		boolean isUSTimezone = timezoneRESTAPIService.checkValidUSTimeZone(timezone);
		if (!isUSTimezone) {
			throw new IllegalArgumentException("Invalid timezone parameter. Only US timezones are supported.");
		}
		WorldAPIResponse response = timezoneRESTAPIService.getTimeZoneDetails(timezone);
		APIResponse body = objectMapper.convertValue(response, APIResponse.class);
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(body);
	}

}
