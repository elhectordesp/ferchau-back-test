package com.ferchauapp.infrastructure.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ForecastDTO {
    private List<RainfallprobabilityDTO> probPrecipitacion;
    private TemperatureDTO temperatura;
    private String unidadTemperatura;
    private double mediaTemperatura;
}
