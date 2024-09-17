package com.ferchauapp.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
@JsonIgnoreProperties(ignoreUnknown = true)

@Data
public class Forecast {
    private List<ProbPrecipitacion> probPrecipitacion;
    private Temperatura temperatura;
    private String unidadTemperatura;
    private double mediaTemperatura;
}
