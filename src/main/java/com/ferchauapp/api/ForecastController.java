package com.ferchauapp.api;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ferchauapp.api.dto.ForecastResponseDTO;
import com.ferchauapp.application.ForecastService;

@RestController
public class ForecastController {
  private final ForecastService forecastService;

  public ForecastController(ForecastService forecastService) {
    this.forecastService = forecastService;
  }

  @GetMapping("/forecast")
  public Optional<ForecastResponseDTO> getForecast(@RequestParam String municipalityId, @RequestParam(required=false, defaultValue="G_CEL") String measurementUnit) {
    return forecastService.getForecast(municipalityId, measurementUnit);
  }
}
