package com.ferchauapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Municipality {
  private String id;
  private String nombre;
  private String latitud;
  private String longitud;
  private String latitudDec;
  private String longitudDec;
  private String altitud;
  private String capital;
  private String numHab;
  private String zonaComarcal;
  private String destacada;
  private String url;
  private String id_old;
}
