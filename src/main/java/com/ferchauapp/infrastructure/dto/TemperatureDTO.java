package com.ferchauapp.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class TemperatureDTO {
    private double minima;
    private double maxima;
}
