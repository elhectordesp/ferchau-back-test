package com.ferchauapp.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {
    private List<ProbPrecipitacion> probPrecipitacion;
    private Temperatura temperatura;
    private String unidadTemperatura;
    private double mediaTemperatura;

    public List<ProbPrecipitacion> getProbPrecipitacion() {
        return probPrecipitacion;
    }

    public void setProbPrecipitacion(List<ProbPrecipitacion> probPrecipitacion) {
        this.probPrecipitacion = probPrecipitacion;
    }

     public Temperatura getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Temperatura temperatura) {
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
