package com.example.sprinboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressDTO {

	@JsonProperty(value="city")
	String city;
	@JsonProperty(value="country")
	String country;

}
