package com.ferchauapp.infrastructure.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastDTO {
    private List<RainfallprobabilityDTO> probPrecipitacion;
    private TemperatureDTO temperatura;
    private String unidadTemperatura;
    private double mediaTemperatura;

    public List<RainfallprobabilityDTO> getProbPrecipitacion() {
        return probPrecipitacion;
    }

    public void setProbPrecipitacion(List<RainfallprobabilityDTO> probPrecipitacion) {
        this.probPrecipitacion = probPrecipitacion;
    }

     public TemperatureDTO getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(TemperatureDTO temperatura) {
        this.temperatura = temperatura;
    }

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
}
