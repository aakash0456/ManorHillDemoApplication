package com.example.springbootmicroservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.sprinbootmicroservice.models.APIResponse;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class SpringBootMicroServiceApplicationIntegrationTest {
	
	@Autowired
	TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;

	@SuppressWarnings("deprecation")
	@Test
	public void testAPI() {
		String timezone = "America/Chicago";
		ResponseEntity<APIResponse> response = restTemplate.getForEntity(UriComponentsBuilder.fromUriString("http://localhost:{port}/time?timezone={timezone}")
				.buildAndExpand(port, timezone).toUriString(), APIResponse.class);
		APIResponse res = new APIResponse("America/Chicago", null, "CDT");
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertThat(response.getBody()).isEqualToIgnoringGivenFields(res, "datetime");
	}
	
	
	@Test()
	public void testInValidAPICall() {
		String timezone = "India";
		ResponseEntity<APIResponse> response = restTemplate.getForEntity(UriComponentsBuilder.fromUriString("http://localhost:{port}/time?timezone={timezone}")
				.buildAndExpand(port, timezone).toUriString(), APIResponse.class);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
	}
}
