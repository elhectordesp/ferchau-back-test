package com.ferchauapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
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

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getLatitud() {
    return latitud;
  }

  public void setLatitud(String latitud) {
    this.latitud = latitud;
  }

  public String getLongitud() {
    return longitud;
  }

  public void setLongitud(String longitud) {
    this.longitud = longitud;
  }

  public String getLatitudDec() {
    return latitudDec;
  }

  public void setLatitudDec(String latitudDec) {
    this.latitudDec = latitudDec;
  }

  public String getLongitudDec() {
    return longitudDec;
  }

  public void setLongitudDec(String longitudDec) {
    this.longitudDec = longitudDec;
  }

  public String getAltitud() {
    return altitud;
  }

  public void setAltitud(String altitud) {
    this.altitud = altitud;
  }

  public String getCapital() {
    return capital;
  }

  public void setCapital(String capital) {
    this.capital = capital;
  }

  public String getNumHab() {
    return numHab;
  }

  public void setNumHab(String numHab) {
    this.numHab = numHab;
  }

  public String getZonaComarcal() {
    return zonaComarcal;
  }

  public void setZonaComarcal(String zonaComarcal) {
    this.zonaComarcal = zonaComarcal;
  }

  public String getDestacada() {
    return destacada;
  }

  public void setDestacada(String destacada) {
    this.destacada = destacada;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
