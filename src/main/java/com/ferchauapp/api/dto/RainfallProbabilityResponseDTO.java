package com.ferchauapp.api.dto;

public class RainfallProbabilityResponseDTO {
  private double value;
  private String periodo;

  public double getValue() {
    return value;
  }
  
 public void setValue(double value) {
    this.value = value;
  }

public String getPeriodo() {
    return periodo;
  }
  
  public void setPeriodo(String periodo) {
    this.periodo = periodo;
  }
}
