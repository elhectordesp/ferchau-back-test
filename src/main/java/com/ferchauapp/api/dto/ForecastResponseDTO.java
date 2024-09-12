package com.ferchauapp.api.dto;

import java.util.List;

public class ForecastResponseDTO {
  private double mediaTemperatura;
  private String unidadTemperatura;
  private List<RainfallProbabilityResponseDTO> probPrecipitacion;
  private TemperatureResponseDTO temperatura;

  public String getUnidadTemperatura() {
    return unidadTemperatura;
  }
  
 public void setUnidadTemperatura(String unidadTemperatura) {
    this.unidadTemperatura = unidadTemperatura;
  }

  public double getMediaTemperatura() {
    return mediaTemperatura;
  }
  
  public void setMediaTemperatura(double mediaTemperatura) {
    this.mediaTemperatura = mediaTemperatura;
  }
  
  public List<RainfallProbabilityResponseDTO> getProbPrecipitacion() {
    return probPrecipitacion;
  }
  
  public void setProbPrecipitacion(List<RainfallProbabilityResponseDTO> probPrecipitacion) {
    this.probPrecipitacion = probPrecipitacion;
  }

  public TemperatureResponseDTO getTemperatura() {
    return temperatura;
  }
  
  public void setTemperatura(TemperatureResponseDTO temperatura) {
    this.temperatura = temperatura;
  }
}
