package com.ferchauapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Temperatura {
    private double minima;
    private double maxima;
}
