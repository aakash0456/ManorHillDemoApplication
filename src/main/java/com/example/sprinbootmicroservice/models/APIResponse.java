package com.example.sprinbootmicroservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class APIResponse {
	private String timezone;
	private String datetime;
	private String abbreviation;
}
