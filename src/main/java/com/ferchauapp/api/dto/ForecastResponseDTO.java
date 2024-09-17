package com.ferchauapp.api.dto;

import java.util.List;

import lombok.Data;

@Data
public class ForecastResponseDTO {
  private double mediaTemperatura;
  private String unidadTemperatura;
  private List<RainfallProbabilityResponseDTO> probPrecipitacion;
  private TemperatureResponseDTO temperatura;
}
