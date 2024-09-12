package com.ferchauapp.infrastructure.models;

import java.util.List;

import com.ferchauapp.domain.Forecast;


public class ForecastResponse {
  private List<Forecast> datos;

  public List<Forecast> getDatos() {
        return datos;
    }

    public void setDatos(List<Forecast> datos) {
        this.datos = datos;
    }
}
