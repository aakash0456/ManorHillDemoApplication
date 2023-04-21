package com.example.sprinbootmicroservice.models;


import java.io.Serializable;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class WorldAPIResponse implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String abbreviation;
	private String timezone;
	private String clientIp;
	private String datetime;
	private int dayOfWeek;
	private int dayOfYear;
	private boolean dst;
	private String dstFrom;
	private int dstOffset;
	private String dstUntil;
	private int rawOffset;
	private int unixtime;
	private String utcDatetime;
	private String utcOffset;
	private int weekNumber;

	@Override
	public String toString() {
		return "WorldAPIResponse [abbreviation=" + abbreviation + ", timezone=" + timezone + ", clientIp=" + clientIp
				+ ", datetime=" + datetime + ", dayOfWeek=" + dayOfWeek + ", dayOfYear=" + dayOfYear + ", dst=" + dst
				+ ", dstFrom=" + dstFrom + ", dstOffset=" + dstOffset + ", dstUntil=" + dstUntil + ", rawOffset="
				+ rawOffset + ", unixtime=" + unixtime + ", utcDatetime=" + utcDatetime + ", utcOffset=" + utcOffset
				+ ", weekNumber=" + weekNumber + "]";
	}

}
