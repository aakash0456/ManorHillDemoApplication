package com.example.springbootmicroservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.sprinbootmicroservice.models.WorldAPIResponse;
import com.example.springbootmicroservice.services.TimezoneRESTAPIService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
class SpringBootMicroserviceApplicationTests {

	@Autowired
	private TimezoneRESTAPIService timezoneRESTAPIService;

	@Test
	public void checkInValidTimeZone() {
		String timezone = "India";
		timezoneRESTAPIService.checkValidUSTimeZone(timezone);
		assertThat(timezoneRESTAPIService.checkValidUSTimeZone(timezone)).isEqualTo(false);
	}

	@Test
	public void checkValidTimeZone() {
		String timezone = "America/Chicago";
		assertThat(timezoneRESTAPIService.checkValidUSTimeZone(timezone)).isEqualTo(true);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void checkValidTimeZoneResponse() {
		String timezone = "America/Chicago";
		WorldAPIResponse res = new WorldAPIResponse("CDT", "America/Chicago", null, null, 0, 0, true,
				"2023-03-12T08:00:00+00:00", 3600, null, 0, 0, null, null, 0);
		assertThat(timezoneRESTAPIService.getTimeZoneDetails(timezone)).isEqualToComparingOnlyGivenFields(res,
				"abbreviation", "timezone");
	}

}
