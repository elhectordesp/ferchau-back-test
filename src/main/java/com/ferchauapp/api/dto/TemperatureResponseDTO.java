package com.ferchauapp.api.dto;

public class TemperatureResponseDTO {
  private double minima;
  private double maxima;

  public double getMinima() {
    return minima;
  }
  
 public void setMinima(double minima) {
    this.minima = minima;
  }

public double getMaxima() {
    return maxima;
  }
  
  public void setMaxima(double maxima) {
    this.maxima = maxima;
  }
}
